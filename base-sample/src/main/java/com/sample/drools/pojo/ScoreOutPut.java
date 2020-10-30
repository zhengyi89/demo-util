package com.sample.drools.pojo;

import java.io.Serializable;

/**
 * 分数测试输出
 *
 * @Author: zhengyi
 * @Date: 2020/10/30 10:57
 */
public class ScoreOutPut implements Serializable {
    private String scoreLevel;

    public String getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(String scoreLevel) {
        this.scoreLevel = scoreLevel;
    }
}
