package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.anno.User;
import com.demo.dto.BaseRespDto;
import com.demo.dto.BindingResultDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2019/11/1 16:04
 */
@RestController
@RequestMapping("test")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/users")
    public PageInfo<User> getUsers() {
        PageHelper.startPage(1, 10);
        List<User> users = null;
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }


    @PostMapping("bindingResult")
    public Object bindingResultTest(@RequestBody @Valid BindingResultDto reqDto, BindingResult bindingResult) {
        logger.info("开始调用bindingResult，入参：{}", JSON.toJSONString(reqDto));
        if (bindingResult.getErrorCount() > 0) {
            StringBuffer errResult = new StringBuffer();
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError fieldError : list) {
                errResult.append(fieldError.getDefaultMessage() + ";");
            }
            return BaseRespDto.getFaildInstance(errResult.toString());
        }
        return BaseRespDto.getSuccInstance();
    }
}
