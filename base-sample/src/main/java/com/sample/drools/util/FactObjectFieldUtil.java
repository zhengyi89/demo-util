package com.sample.drools.util;

import com.sample.drools.pojo.FactorContext;
import com.sample.drools.pojo.FactorVariableValue;
import javassist.*;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FactObjectFieldUtil {
    private final static String SETTER_STR = "set";
    private final static String GETTER_STR = "get";
    // type/fieldName
    private final static String fieldTemplate = "private %s %s;";

    /**
     * 给Fact对象赋值
     *
     * @param context
     * @param factorVariableValueList
     * @throws NotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValue(FactorContext context, List<FactorVariableValue> factorVariableValueList) throws NotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if (factorVariableValueList != null && factorVariableValueList.size() > 0) {
            for (FactorVariableValue factorVariableValue : factorVariableValueList) {
                setValue(context, factorVariableValue);
            }

        }

    }

    public static void setValue(FactorContext context, FactorVariableValue factorVariableValue) throws NotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class clazz = context.getClass();
        // 通过反射，给 FactorContext 类属性赋值
        String setMethodName = "set" + StringUtils.capitalize(factorVariableValue.getFactorName());
//		String getMethodName = "get" + StringUtils.capitalize(factorVariableValue.getFactorName());
        Method setMethod = clazz.getDeclaredMethod(setMethodName, String.class);
        setMethod.invoke(context, new Object[]{factorVariableValue.getFactorValue()});
        // Method getMethod = clazz.getDeclaredMethod(getMethodName);
        // System.out.println(getMethod.toGenericString());
        // Object result = getMethod.invoke(context, new Object[] {});


    }

    /**
     * 创建新的FactorContext class,并添加新的字段
     *
     * @param factorNameList 字段列表
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    public static void createField(List<String> factorNameList) throws NotFoundException, CannotCompileException {

        if (factorNameList != null && factorNameList.size() > 0) {
            ClassPool pool = ClassPool.getDefault();
//			CtClass factorContextClass = pool.get("com.pandorasoft.precogs.utils.FactorContext");

            CtClass factorContextClass = pool.makeClass("com.sample.drools.pojo.FactorContext");

            String setMethodName = null;
            String getMethodName = null;

            for (String factorName : factorNameList) {
                // 判断 FactorContext 类 是否包含此 factorName属性,没有则动态创建,并赋值
                // 增加字段

                // 增加 getter和setter
                try {
                    setMethodName = SETTER_STR + StringUtils.capitalize(factorName);
                    getMethodName = GETTER_STR + StringUtils.capitalize(factorName);

                    CtField newField = CtField.make(String.format(fieldTemplate, "java.lang.String", factorName),
                            factorContextClass);
                    factorContextClass.addField(newField);

                    CtMethod ageSetter = CtNewMethod.setter(setMethodName, newField);
                    factorContextClass.addMethod(ageSetter);
                    CtMethod ageGetter = CtNewMethod.getter(getMethodName, newField);
                    factorContextClass.addMethod(ageGetter);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
            factorContextClass.toClass();

        }

    }

}
