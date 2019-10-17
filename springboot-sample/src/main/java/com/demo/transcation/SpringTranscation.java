package com.demo.transcation;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Spring 的事务管理方式从大的方向上来讲，
 * 分为 编程式事务和声明式事务，
 * 编程式事务就是实现PlatformTransactionManager 接口 和 TransactionTemplate 两种方式。
 *
 * @Author: zhengyi
 * @Date: 2019/10/12 17:59
 */
public class SpringTranscation {

    public static void main(String[] args) {
        //new 一个事务
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //初始化事务,参数定义事务的传播类型;
//        TransactionStatus status = transactionManager.getTransaction(def);
        //获得事务状态

//        try {
//            …………….
//            //提交事务;
//            transactionManager.commit(status);
//        } catch (…..){
//            //回滚事务;
//            transactionManager.rollback(status);
//        }

    }
}
