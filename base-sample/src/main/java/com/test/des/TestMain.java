package com.test.des;

import org.junit.Test;


/**
 * @author zhengy
 * @date 2016/08/08
 */
public class TestMain {

	@Test
	public void aesTest(){
		
		String content = "test";  
		String password = "12345678";  
		//加密  
		System.out.println("加密前：" + content);  
//		byte[] encryptResult = Aes.encrypt(content, password);  
//		//解密  
//		byte[] decryptResult = Aes.decrypt(encryptResult,password);  
//		System.out.println("解密后：" + new String(decryptResult));  
//		
		
	}
}
