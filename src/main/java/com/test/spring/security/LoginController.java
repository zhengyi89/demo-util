//package com.test.spring.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.test.bean.UserInfo;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by EalenXie on 2018/1/11.
// */
//@Controller
//public class LoginController {
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login() {
//		return new ModelAndView("login1");
//	}
//
//	@RequestMapping("/")
//	public String root() {
//		return "index";
//	}
//
//	public UserInfo getUser() { // 为了session从获取用户信息,可以配置如下
//		UserInfo user = new UserInfo();
//		SecurityContext ctx = SecurityContextHolder.getContext();
//		Authentication auth = ctx.getAuthentication();
//		if (auth.getPrincipal() instanceof UserDetails)
//			user = (UserInfo) auth.getPrincipal();
//		return user;
//	}
//
//	public HttpServletRequest getRequest() {
//		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//	}
//}