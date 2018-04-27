package com.test.des;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;
import org.omg.IOP.Encoding;

import com.test.io.Base64Test;

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
