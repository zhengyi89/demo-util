package com.sample.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * fileName：SignVerifyDemo
 *
 * @author ：Miles zhu
 * Date    ：2020/1/15 14:35
 * -------------------------
 * 功能和描述：
 **/
public class SignVerifyDemo {
    public static final String PRIVATE_KEY_PASSWORD = "111111";
//    public static final String PRIVATE_KEY_PASSWORD = "123456";

//    public static final String PUBLIC_KEY_FILE_PATH = "D:\\signverify\\rootcert\\ISSUE.cer";
//    public static final String PRIVATE_KEY_FILE_PATH = "D:\\signverify\\rootcert\\ISSUE.pfx";
    public static final String PUBLIC_KEY_FILE_PATH = "D:\\tmp\\keystore\\public-rsa.cer";
    public static final String PRIVATE_KEY_FILE_PATH = "D:\\tmp\\keystore\\user-rsa.pfx";
    public static final String ALIAS_NAME = "1";
    public static final String DEFAULT_UTF8 = "UTF-8";

    public static void main(String[] args) {
        String originalData = "Hello我是原始的数据World";
        String sign = sign(originalData);
        System.out.println(sign);
        boolean verify = verify(sign, originalData);
        if (verify) {
            System.out.println("验签通过");
        } else {
            System.out.println("验签失败");
        }

    }

    /**
     * 签名
     */
    public static String sign(String originalData) {
        String base64Sign = "";
        try {

            //返回与此给定的别名的密码，并用给定的密钥来恢复它
            PrivateKey privateKey = getPrivateKey();

            //返回指定签名的Signature对象
            Signature sign = Signature.getInstance("SHA1withRSA");

            //初始化这个用于签名的对象
            sign.initSign(privateKey);

            byte[] bysData = originalData.getBytes(DEFAULT_UTF8);

            //使用指定的byte数组更新要签名的数据
            sign.update(bysData);
            //返回所有已经更新数据的签名字节
            byte[] signByte = sign.sign();
            //对其进行Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            base64Sign = encoder.encode(signByte);
        } catch (Exception e) {
            System.out.println("签名异常");
            e.printStackTrace();
        }
        return base64Sign;
    }


    /**
     * 验签
     *
     * @param signStr      签名数据
     * @param originalData 原始数据
     * @return
     */
    public static boolean verify(String signStr, String originalData) {
        System.out.println("开始进行验签，原始数据为：" + originalData);
        try {
            //从此证书对象中获取公钥
            PublicKey publicKey = getPublicKey();

            //将签名数据
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] signed = decoder.decodeBuffer(signStr);

            //通过Signature的getInstance方法，获取指定签名算法的Signature对象
            Signature signature = Signature.getInstance("SHA1withRSA");
            //初始化用于验证的对象
            signature.initVerify(publicKey);
            //使用指定的byte[]更新要验证的数据
            signature.update(originalData.getBytes(DEFAULT_UTF8));
            //验证传入的签名
            return signature.verify(signed);
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 获取公钥
     *
     * @return
     */
    private static PublicKey getPublicKey() {
        InputStream in = null;
        try {
            in = new FileInputStream(PUBLIC_KEY_FILE_PATH);
            //获取实现指定证书类型的CertificateFactory对象
            CertificateFactory cf = CertificateFactory.getInstance("x509");
            //生成一个证书对象，并从执行的输入流中读取数据对它进行初始化
            Certificate certificate = cf.generateCertificate(in);
            //从此证书中获取公钥
            return certificate.getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 获取私钥
     *
     * @return
     */
    private static PrivateKey getPrivateKey() {
        InputStream in = null;
        try {
            in = new FileInputStream(PRIVATE_KEY_FILE_PATH);
            //返回指定类型的KeyStore对象
            KeyStore keyStore = KeyStore.getInstance("PKCS12");

            char[] pscs = PRIVATE_KEY_PASSWORD.toCharArray();
            //从给定的输入流中加载此keyStore
            keyStore.load(in, pscs);
            //返回与给定别名关联的密钥，并用给定的密码来恢复它
            return (PrivateKey) keyStore.getKey(ALIAS_NAME, pscs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}