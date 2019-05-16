package com.test.spring.zhengy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.service.ChrisService;
import com.test.spring.zhengy.anno.SelfAutowired;
import com.test.spring.zhengy.anno.SelfController;
import com.test.spring.zhengy.anno.SelfRequestMapping;

@SelfController
@SelfRequestMapping("/chris")
public class ChrisController {

	@SelfAutowired
	ChrisService chrisService;

	@SelfRequestMapping("/query")
	public void query(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name,
			@RequestParam("age") String age) throws IOException {
		String result = chrisService.query(name, age);
		response.getWriter().write(result);
	}

}
