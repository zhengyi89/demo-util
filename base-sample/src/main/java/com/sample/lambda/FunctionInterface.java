package com.sample.lambda;

import com.sample.lambda.model.Person;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * 函数式接口
 *
 * @Description：函数接口是只有一个抽象方法的接口，用作 Lambda 表达式的类型。使用@FunctionalInterface注解修饰的类，
 * 编译器会检测该类是否只有一个抽象方法或接口，否则，会报错。可以有多个默认方法，静态方法。
 * 函数接口是只有一个抽象方法的接口，用作 Lambda 表达式的类型。使用@FunctionalInterface注解修饰的类，
 * 编译器会检测该类是否只有一个抽象方法或接口，否则，会报错。可以有多个默认方法，静态方法。
 * @Author: zhengyi
 * @Date: 2020/11/12 9:46
 */
public class FunctionInterface {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 20;
        Person person = new Person("zheng", "yi", "softDev", "男", 32, 5000);
        System.out.println(predicate.test(person.getAge()));

        Consumer consumer = System.out::println;
        consumer.accept("hello chris！");

        Function<Person, String> function = Person::getName;
        String name = function.apply(person);
        System.out.println("person name:" + name);

        Supplier<Integer> supplier =
                () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);
    }
}
