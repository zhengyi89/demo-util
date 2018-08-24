package com.test.python;

import java.io.*;

/**
 * @author zhengy
 * @date 18/8/22上午9:10
 */

public class MyDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            System.out.println("start");
            String[] args1 = new String[]{"python", "/Users/zhengy/Documents/PycharmProjects/dhgate/tradewind/doc/Test.py"};
            Process pr = Runtime.getRuntime().exec(args1);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String exe = "python";
//        String command = "/Users/zhengy/Desktop/Test1.py";
//        String num1 = "1";
//        String num2 = "21";
//        String[] cmdArr = new String[] {exe, command, num1, num2};
//        Process process = Runtime.getRuntime().exec(cmdArr);
//        InputStream is = process.getInputStream();
//        DataInputStream dis = new DataInputStream(is);
//        String str = dis.readLine();
//        process.waitFor();
//        System.out.println(str);
    }

    public void test() {
        System.out.println("我的第一个方法C");
    }

}