package com.sample.util;

import java.util.*;

/**
 * 现在程序中有一组学生成绩数据（getScoreList()返回结果），每条数据为某个学生的某科成绩。学生成绩可能不是4科都有，可能有缺科。
 * 要求对这组数据进行数据转换和计算处理，转换成学生记录列表，每条记录里面有4科成绩和总成绩，并在此基础上计算全班的平均成绩。
 * 要求列表按总成绩从高到低排序。计算平均成绩时，请考虑缺课时的情况。
 * 需要注意的是，最终完成代码的代码质量（逻辑是否清晰，变量/方法命名是否合理等），将作为考察标准的一部分
 * 结果按以下格式控制台输出即可
 * 姓名    数学  语文  英语  物理  总成绩
 * 王五    77   82   90   65   434
 * 张三    65   84   89       316
 * 李四    89   76       76   313
 * …
 * 平均成绩 83.5  70.5  78   82.5  314.5
 */
public class Test {

    public static void main(String[] args) {
        new Test().test();
    }

    public void test() {
        Map<String, Double[]> transcripts = new HashMap<>();

        List<ScoreVo> scoreList = getScoreList();

        // 获取科目并放到集合中
        Map<String, Integer> courseMap = new LinkedHashMap<>();
        courseMap.put("语文",0);
        courseMap.put("物理",1);
        courseMap.put("英语",2);
        courseMap.put("数学",3);

        for (ScoreVo scoreVo : scoreList) {
            Double[] scores = transcripts.get(scoreVo.studentName);
            if (scores == null) {
                scores = new Double[courseMap.size() + 1];
                transcripts.put(scoreVo.studentName, scores);
            }

            for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
                if (entry.getKey().equals(scoreVo.courseName)) {
                    scores[entry.getValue()] = scoreVo.score;
                }
            }
        }

        // 用来存放每科总分数,并初始化
        Double[] scoreAddArgs = new Double[courseMap.size()];
        // 用来存放每科参与统计的学生数,并初始化
        Integer[] stuCountArgs = new Integer[courseMap.size()];
        for (int i = 0; i < courseMap.size(); i++) {
            scoreAddArgs[i] = Double.valueOf(0);
            stuCountArgs[i] = Integer.valueOf(0);
        }
        // 计算总分
        for (Map.Entry<String, Double[]> entry : transcripts.entrySet()) {
            Double sumScore = Double.valueOf(0);
            Double[] scores = entry.getValue();
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] != null) {
                    sumScore += scores[i];
                    scoreAddArgs[i] += scores[i];
                    stuCountArgs[i] += 1;
                }
            }
            entry.getValue()[courseMap.size()] = sumScore;
        }

        System.out.print("姓名" + "-----");
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            System.out.print(entry.getKey() + "-----");
        }
        System.out.println("总分");
        TreeMap<Double, StudentVo> treeMap = new TreeMap<>();

        for (Map.Entry<String, Double[]> entry : transcripts.entrySet()) {
//            System.out.println(JSON.toJSONString(entry.getValue()));
            Double[] scores = entry.getValue();
            StudentVo studentVo = new StudentVo();
            studentVo.setChineseScore(scores[0]);
            studentVo.setPhysicalScore(scores[1]);
            studentVo.setEnglishScore(scores[2]);
            studentVo.setMathScore(scores[3]);
            studentVo.setTotalScore(scores[4]);
            studentVo.setName(entry.getKey());
            treeMap.put(scores[courseMap.size()], studentVo);
//            System.out.println(entry.getKey() + "-----" + JSON.toJSONString(entry.getValue()));
        }

        Set<Double> set = treeMap.descendingKeySet();
        for (Double sumScore : set) {
            StudentVo studentVo = treeMap.get(sumScore);
            System.out.println(studentVo.getName() + "-----" + studentVo.getChineseScore() + "-----" + studentVo.getPhysicalScore() +
                    "-----" + studentVo.getEnglishScore() + "-----" + studentVo.getMathScore()
                    + "-----" + studentVo.getTotalScore());
        }
//        for (Map.Entry<Double ,StudentVo> entry : treeMap.entrySet()) {
//            System.out.println(entry.getKey() + "-----" + JSON.toJSONString(entry.getValue()));
//        }

        System.out.print("平均成绩--");
        // 计算平均分
        for (int i = 0; i < scoreAddArgs.length; i++) {
            double avg = scoreAddArgs[i] * 100 / stuCountArgs[i];
            System.out.print((float) Math.round(avg) / 100 + "----");
        }

    }

    public List<ScoreVo> getScoreList() {
        List<ScoreVo> scoreList = new ArrayList<ScoreVo>();
        scoreList.add(new ScoreVo("张三", "语文", 80));
        scoreList.add(new ScoreVo("张三", "物理", 76));
        scoreList.add(new ScoreVo("李四", "语文", 78));
        scoreList.add(new ScoreVo("茅十八", "英语", 65));
        scoreList.add(new ScoreVo("李四", "数学", 88));
        scoreList.add(new ScoreVo("李四", "物理", 87));
        scoreList.add(new ScoreVo("王五", "语文", 67));
        scoreList.add(new ScoreVo("张三", "数学", 76));
        scoreList.add(new ScoreVo("李四", "英语", 89));
        scoreList.add(new ScoreVo("王五", "数学", 65));
        scoreList.add(new ScoreVo("赵六", "物理", 95));
        scoreList.add(new ScoreVo("王五", "英语", 78));
        scoreList.add(new ScoreVo("王五", "物理", 65));
        scoreList.add(new ScoreVo("赵六", "语文", 89));
        scoreList.add(new ScoreVo("赵六", "英语", 87));
        scoreList.add(new ScoreVo("黄七", "语文", 78));
        scoreList.add(new ScoreVo("黄七", "数学", 65));
        scoreList.add(new ScoreVo("刘八", "英语", 87));
        scoreList.add(new ScoreVo("张三", "英语", 56));
        scoreList.add(new ScoreVo("黄七", "物理", 76));
        scoreList.add(new ScoreVo("刘八", "数学", 89));
        scoreList.add(new ScoreVo("黄七", "英语", 98));
        scoreList.add(new ScoreVo("刘八", "语文", 56));
        scoreList.add(new ScoreVo("刘八", "物理", 76));
        scoreList.add(new ScoreVo("钱九", "语文", 88));
        return scoreList;
    }
}
