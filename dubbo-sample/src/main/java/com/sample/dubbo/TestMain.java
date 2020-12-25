package com.sample.dubbo;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sample.dubbo.demo.service.AnnotationService;

import java.net.MalformedURLException;

public class TestMain {

    public static void invokeDubboService() {
        String serviceUrl = "http://10.1.193.137:8080/annotation-provider/com.sample.dubbo.demo.service" +
				".AnnotationService";

        HessianProxyFactory factory = new HessianProxyFactory();

        AnnotationService searchService = null;

        try {
            searchService = (AnnotationService) factory.create(AnnotationService.class,
                    serviceUrl);
			searchService.sayHello("zhagnyi");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		invokeDubboService();
	}
}
