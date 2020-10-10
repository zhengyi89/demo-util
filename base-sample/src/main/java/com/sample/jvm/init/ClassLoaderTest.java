package com.sample.jvm.init;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同类加载器对instanceof关键字运行结果的影响
 *
 * @Author: zhengyi
 * @Date: 2020/9/29 15:10
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileNanme = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileNanme);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Object obj = myLoader.loadClass("com.sample.jvm.init.DeadLoopClass").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof  DeadLoopClass);

        DeadLoopClass deadLoopClass = new DeadLoopClass();
        System.out.println(deadLoopClass instanceof  DeadLoopClass);

        DeadLoopClass deadLoopClass1 = new DeadLoopClass();
        System.out.println(deadLoopClass1 instanceof  DeadLoopClass);
    }
}
