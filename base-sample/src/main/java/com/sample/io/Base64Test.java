package com.sample.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 * ͼƬ��base64�ַ���֮���ת��
 * 
 * @author zhengy
 *
 */
public class Base64Test {
	public static void main(String[] args) {
		String strImg = GetImageStr();
		System.out.println(strImg);
	}

	public static String GetImageStr() {
		String imgFile = "d://TestImg.java";
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println(data);
		return data.toString();
	}

}
