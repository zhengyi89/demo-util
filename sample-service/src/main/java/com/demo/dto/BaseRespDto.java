package com.demo.dto;

import com.demo.enumtype.ResponseCodeEnum;
import org.apache.commons.lang.StringUtils;

/**
 * 基础返回dto
 *
 * @Author: zhengyi
 * @Date: 2019/11/27 11:08
 */
public class BaseRespDto {
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

    public static BaseRespDto getSuccInstance() {
        BaseRespDto baseRespDto = new BaseRespDto();
        baseRespDto.setCode(ResponseCodeEnum.SUCCESS.getCode());
        baseRespDto.setMsg(ResponseCodeEnum.SUCCESS.getMsg());
        return baseRespDto;
    }


    public static BaseRespDto getFaildInstance() {
        return getFaildInstance(null);
    }

    public static BaseRespDto getFaildInstance(String msg) {
        BaseRespDto baseRespDto = new BaseRespDto();
        baseRespDto.setCode(ResponseCodeEnum.FAILD.getCode());
        if (StringUtils.isBlank(msg)) {
            baseRespDto.setMsg(ResponseCodeEnum.FAILD.getMsg());
        } else {
            baseRespDto.setMsg(msg);
        }
        return baseRespDto;
    }
}
