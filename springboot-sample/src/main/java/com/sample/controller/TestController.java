package com.sample.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sample.anno.User;
import com.sample.dto.BaseRespDto;
import com.sample.dto.BindingResultDto;
import com.sample.model.LogInfo;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${book.author}")
    private String author;
    @Value("${book.name}")
    private String name;

    @RequestMapping(value = "/index", method =RequestMethod.POST )
    @ResponseBody
    String index(@RequestBody LogInfo loginfo) {
        return "success";
    }

    @RequestMapping(value = "/index1", method =RequestMethod.POST)
    String index1(@RequestBody LogInfo loginfo) {
        return "success";
    }

    @GetMapping(value = "/users")
    public PageInfo<User> getUsers() {
        PageHelper.startPage(1, 10);
        List<User> users = null;
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    public String test(String s) {
        return "hello " + s;
    }


    /**
     * BindingResult使用
     * 1.在属性的get方法上使用validation注解设置属性的校验规则和验证信息
     * 2.controller方法绑定BindingResult对象，从bindingResult对象中获取验证结果信息
     *
     * @param reqDto
     * @param bindingResult
     * @return
     */
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
