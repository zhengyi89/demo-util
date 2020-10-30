package com.sample.drools.util;


import org.drools.template.ObjectDataCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author zhengy
 */
public class DroolsHelper {
    private final static Logger logger = LoggerFactory.getLogger(DroolsHelper.class);

    /**
     * 根据模板获取drools执行脚本
     *
     * @param variableValueMap 数据集
     * @param template         drools模板
     * @return
     */
    public static String getDrlFromTemplate(Map<String, Object> variableValueMap, String template) {

        Collection<Map<String, Object>> paramMaps = new ArrayList<Map<String, Object>>();
        paramMaps.add(variableValueMap);

        ObjectDataCompiler converter = new ObjectDataCompiler();

        InputStream targetStream = new ByteArrayInputStream(template.getBytes());
        String drl = converter.compile(paramMaps, targetStream);
        logger.info("drl script -----------------");
        logger.info(drl);
        return drl;

    }
}
