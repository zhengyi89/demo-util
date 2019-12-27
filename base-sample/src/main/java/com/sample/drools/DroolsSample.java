package com.sample.drools;

import com.sample.drools.pojo.*;
import com.sample.drools.util.DroolsHelper;
import com.sample.drools.util.FactObjectFieldUtil;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * @Author: zhengyi
 * @Date: 2019/12/25 18:00
 */
public class DroolsSample {

    private final static Logger logger = LoggerFactory.getLogger(DroolsSample.class);

    /**
     * 根据factor，创建新的FactorContext
     */
    @Before
    public void setUp() {
        List<String> fieldList = new ArrayList<String>();
        fieldList.add("age");
        try {
            FactObjectFieldUtil.createField(fieldList);
        } catch (NotFoundException e) {
            e.printStackTrace();
            fail();
        } catch (CannotCompileException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * 规则编译(KnowledgeBuilder)
     */
    @Test
    public void testGetDrlFromTemplate() {
        Map<String, Object> variableMap = new HashMap<String, Object>();
        variableMap.put("ageStart", 20);
        variableMap.put("ageEnd", 40);
        try {
            System.out.println(this.getClass().getResource("/drools/demoTemplate.drl"));
            InputStream inputStream = this.getClass().getResourceAsStream("/drools/demoTemplate.drl");
            String template = IOUtils.toString(inputStream);
            String scriptTxt = DroolsHelper.getDrlFromTemplate(variableMap, template);
            System.out.println(scriptTxt);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * 执行drools脚本
     */
    @Test
    public void templateDroolsTest() {
        try {
            System.out.println(this.getClass().getResource("/drools/demo.drl"));
            InputStream inputStream = this.getClass().getResourceAsStream("/drools/demo.drl");
            // 生成drools脚本
            String scriptTxt = IOUtils.toString(inputStream);
            KieHelper helper = new KieHelper();
            helper.addContent(scriptTxt, ResourceType.DRL);
            KieSession kSession = helper.build().newKieSession();
            // 创建factor
            FactorVariableValue factorVariableValue = new FactorVariableValue();
            factorVariableValue.setFactorName("age");
            factorVariableValue.setFactorValue("100");
            FactorContext context = new FactorContext();
            try {
                FactObjectFieldUtil.setValue(context, factorVariableValue);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            kSession.insert(context);

            final RuleOutput ruleOutput = new RuleOutput();
            // 获取全局变量
            kSession.setGlobal("ruleOutput", ruleOutput);
            // 执行规则
            int count = kSession.fireAllRules();
            logger.info("Fire " + count + " rule(s)!");

            logger.info("is deny:" + ruleOutput.isDeny());
            kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Test
    public void scoreDroolsTest() {
        try {
            System.out.println(this.getClass().getResource("/drools/score.drl"));
            InputStream inputStream = this.getClass().getResourceAsStream("/drools/score.drl");
            String scriptTxt = IOUtils.toString(inputStream);
            KieHelper helper = new KieHelper();
            helper.addContent(scriptTxt, ResourceType.DRL);
            KieSession kSession = helper.build().newKieSession();

            Score s = new Score(99);
            kSession.insert(s);
            kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Test
    public void helloDroolsTest() {
        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();//kmodule.xml
        KieSession kieSession = kieContainer.newKieSession("helloWorldSession");
        //加入数据
        Message message = new Message();
        message.setId("123");
        message.setName("haha");
        kieSession.insert(message);
        //执行规则
        int i = kieSession.fireAllRules();
        System.out.println("========" + i);
        kieSession.dispose();
    }

}
