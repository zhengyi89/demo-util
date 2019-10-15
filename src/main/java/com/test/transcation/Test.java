package com.test.transcation;

import org.springframework.transaction.TransactionStatus;

/**
 * @Author: zhengyi
 * @Date: 2019/10/12 17:59
 */
public class Test {
//    public static void main(String[] args) {
//        Exception e = (Exception)getDbfeelTransactionTemplate().execute(new TransactionCallback() {
//            public Object doInTransaction(TransactionStatus status) {
//                try {
//                    for(Long id:idList) {
//                        userItemDAO.updateStatus(id,userId,1);
//                    }
//                    return null;
//                }catch(DAOException e) {
//                    status.setRollbackOnly();
//                    return e;
//                }
//                catch (Exception e) {
//                    status.setRollbackOnly();
//                    return e;
//                }
//            }
//        });
//    }
}
