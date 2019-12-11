package com.sample.dubbo;

import com.caucho.hessian.client.HessianProxyFactory;

public class TestMain {

	public void invokeDubboService() {
		String serviceUrl = "http://192.168.120.233:8081/weixin-web/soa/com.zbjdl.common.wx.service.WeixinService";

		HessianProxyFactory factory = new HessianProxyFactory();

		// WeixinService searchService = null;
		// try {
		// searchService = (WeixinService) factory.create(WeixinService.class,
		// serviceUrl);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
		//
	}
}
