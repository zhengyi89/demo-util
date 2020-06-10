package com.sample.util;

/**
 * @Author: zhengyi
 * @Date: 2020/5/19 14:20
 */

class ScoreVo {
    public String studentName;
    public String courseName;
    public double score;

    public ScoreVo(String studentName, String courseName, double score) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.studentName + "\t" + this.courseName + "\t" + this.score;
    }
}

class StudentVo {
    private String name;
    private Double chineseScore;
    private Double mathScore;
    private Double englishScore;
    private Double physicalScore;
    private Double totalScore;

    public StudentVo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Double chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    public Double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Double englishScore) {
        this.englishScore = englishScore;
    }

    public Double getPhysicalScore() {
        return physicalScore;
    }

    public void setPhysicalScore(Double physicalScore) {
        this.physicalScore = physicalScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}