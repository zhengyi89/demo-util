package com.test.des;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DesTest {

	public static final byte[] Key = "0o.~'`Oo".getBytes();
	private static final String Algorithm = "DES"; // ���� �����㷨,����
													// DES,DESede,Blowfish

	// �����ַ���
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// ������Կ
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// ����
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// �����ַ���
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// ������Կ
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// ����
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// ����°�ȫ�㷨,�����JCE��Ҫ������ӽ�ȥ
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		final byte[] keyBytes = Key;
		// 8�ֽڵ���Կ
		String szSrc = "root";
		System.out.println("����ǰ���ַ���:" + szSrc);
		byte[] encoded = encryptMode(keyBytes, szSrc.getBytes());
		System.out.println("���ܺ���ַ���:" + new String(encoded));
		byte[] srcBytes = decryptMode(keyBytes, encoded);
		System.out.println("���ܺ���ַ���:" + (new String(srcBytes)));
	}

}
