package com.sample.enumtype;

/**
 * 返回状态枚举
 *
 * @author zhengy
 * @date: 2018年11月29日 下午9:38:48
 */
public enum ResponseCodeEnum {
    FAILD("99999", "失败"),
    SUCCESS("00000", "成功");


    /**
     * 判断enum值是否合法
     *
     * @param code
     * @return
     */
    public static boolean isEnum(String code) {
        ResponseCodeEnum[] items = ResponseCodeEnum.values();
        for (ResponseCodeEnum item : items) {
            if (item.name().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static ResponseCodeEnum toEnum(String code) {
        ResponseCodeEnum[] items = ResponseCodeEnum.values();
        for (ResponseCodeEnum item : items) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    private ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
