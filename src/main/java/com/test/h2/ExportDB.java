package com.test.h2;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author zhengy
 * @date 18/8/15下午2:19
 * @Description: 生成数据库工具
 */
public class ExportDB {
    /**
     * @param args
     */
    public static void main(String[] args) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        MetadataImplementor metadataImplementor = (MetadataImplementor)
                new MetadataSources(serviceRegistry).buildMetadata();

        System.out.println("111---");

        SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
        System.out.println("111---");

        export.create(true, true);


        System.out.println("222------");

    }
}