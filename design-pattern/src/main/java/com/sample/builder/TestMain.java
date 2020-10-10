package com.sample.builder;

import com.alibaba.fastjson.JSON;
import com.sample.builder.general.Computer;
import com.sample.builder.general.Director;
import com.sample.builder.general.HighConfigBuider;
import com.sample.builder.general.LowConfigBuilder;
import com.sample.builder.varietal.Person;
import org.junit.Test;

/**
 * 建造者模式
 *
 * @author zhengy
 * @date 20/10/10下午9:26
 */
public class TestMain {


    @Test
    public void generalBuilderTest() {
        Director director = new Director();//创建装机人员
        director.setBuilder(new LowConfigBuilder()); //告诉装机人员电脑配置，这里为低配版
        director.createComputer(); //装机人员开始组装
        Computer computer = director.getComputer(); //从装机人员获取组装好的电脑
        System.out.println("电脑配置：" + computer.toString());  //查看电脑配置


        director.setBuilder(new HighConfigBuider());
        director.createComputer();
        computer = director.getComputer();
        System.out.println("电脑配置：" + computer.toString());
    }


    @Test
    public void varietalBuilderTest() {
        Person person = new Person.Builder("张三", "男").age("12").money("1000000")
                .car("宝马").build();
        System.out.println(JSON.toJSONString(person));
    }

}