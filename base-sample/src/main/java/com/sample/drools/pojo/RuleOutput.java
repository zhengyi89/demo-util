package com.sample.drools.pojo;

import java.io.Serializable;


public class RuleOutput implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4292378779413274527L;
    /**
     * 是否被拒绝 ,模式是通过
     */
    private boolean isDeny = false;

    public boolean isDeny() {
        return isDeny;
    }

    public void setDeny(boolean isDeny) {
        this.isDeny = isDeny;
    }


}
