package com.test.python;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhengy
 * @date 18/8/22上午9:34
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
//        System.setProperty("python.home", "~/Documents/PycharmProjects/python/venv/bin/python");
//
//        // 1. Python面向函数式编程: 在Java中调用Python函数
//        String pythonFunc = "/Users/zhengy/Documents/PycharmProjects/dhgate/tradewind/doc/Test.py";
//
//        PythonInterpreter pi1 = new PythonInterpreter();
//        // 加载python程序
//        pi1.execfile(pythonFunc);
//        // 调用Python程序中的函数
//        PyFunction pyf = pi1.get("printinfo", PyFunction.class);
//        PyObject dddRes = pyf.__call__(Py.newString("aaa"), Py.newString("aaab"));
//        System.out.println(dddRes);
//        pi1.cleanup();
//        pi1.close();

//        // 2. 面向对象式编程: 在Java中调用Python对象实例的方法
//        String pythonClass = "D:\\calculator_clazz.py";
//        // python对象名
//        String pythonObjName = "cal";
//        // python类名
//        String pythonClazzName = "Calculator";
//        PythonInterpreter pi2 = new PythonInterpreter();
//        // 加载python程序
//        pi2.execfile(pythonClass);
//        // 实例化python对象
//        pi2.exec(pythonObjName + "=" + pythonClazzName + "()");
//        // 获取实例化的python对象
//        PyObject pyObj = pi2.get(pythonObjName);
//        // 调用python对象方法,传递参数并接收返回值
//        PyObject result = pyObj.invoke("power", new PyObject[] {Py.newInteger(2), Py.newInteger(3)});
//        double power = Py.py2double(result);
//        System.out.println(power);

//        pi2.cleanup();
//        pi2.close();




        System.setProperty("python.home", "/Users/zhengy/application/jython2.7.0");
        PythonInterpreter interpreter = new PythonInterpreter();

        interpreter.execfile("/Users/zhengy/Desktop/my1.py");
        PyFunction func = (PyFunction)interpreter.get("adder",PyFunction.class);

        int a = 2010, b = 2 ;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());

    }
}