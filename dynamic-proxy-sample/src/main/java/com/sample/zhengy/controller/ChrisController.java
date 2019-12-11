package com.sample.zhengy.controller;

import com.sample.zhengy.anno.SelfController;
import com.sample.zhengy.anno.SelfRequestMapping;

@SelfController
@SelfRequestMapping("/chris")
public class ChrisController {

//	@SelfAutowired
//	ChrisService chrisService;
//
//	@SelfRequestMapping("/query")
//	public void query(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name,
//			@RequestParam("age") String age) throws IOException {
//		String result = chrisService.query(name, age);
//		response.getWriter().write(result);
//	}

}
