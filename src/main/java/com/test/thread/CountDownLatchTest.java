package com.test.thread;

public class CountDownLatchTest {
		public static void  main(String[] args) {
			//testWaitThread();
			testConcurrent();
			   }


			/**

			* 1、模拟所有子线程都执行完成后再执行主线程

			* countdownLatch计数，模拟子线程执行完成之后再执行主线程

			* 这个也可以用future来实现

			*

			*/

			publicstaticvoidtestWaitThread()

			{

			final CountDownLatchlatch=newCountDownLatch(2);

			newThread(){

			     publicvoidrun() {

			       try{

			         System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");

			        Thread.sleep(3000);

			        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");

			        latch.countDown();

			      }catch(InterruptedExceptione) {

			        e.printStackTrace();

			      }

			     };

			   }.start();



			   newThread(){

			     publicvoidrun() {

			       try{

			         System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");

			         Thread.sleep(3000);

			         System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");

			         latch.countDown();

			      }catch(InterruptedExceptione) {

			        e.printStackTrace();

			      }

			     };

			   }.start();



			   try{

			     System.out.println("等待2个子线程执行完毕...");

			    latch.await();

			    System.out.println("2个子线程已经执行完毕");

			    System.out.println("继续执行主线程");

			  }catch(InterruptedExceptione) {

			    e.printStackTrace();

			  }

			}



			/**

			 * 线程数量

			 */

			 publicstaticfinalintTHREAD_NUM= 100;



			 /**

			 * 开始时间

			 */

			 privatestaticlongstartTime= 0L;

			 /**

			 * 2、模拟高并发

			 */

			publicstaticvoidtestConcurrent()

			{


			 try{

			     startTime= System.currentTimeMillis();

			     System.out.println("CountDownLatch started at: "+startTime);



			     // 初始化计数器为1

			     CountDownLatchcountDownLatch=newCountDownLatch(1);



			     for(inti= 0;i<THREAD_NUM;i++) {

			       newThread(newRun(countDownLatch)).start();

			     }



			     // 启动多个线程

			     countDownLatch.countDown();



			   }catch(Exceptione) {

			     System.out.println("Exception: "+e);

			   }

			}


			/**

			 * 线程类

			 */

			 privatestaticclassRunimplementsRunnable {

			   privatefinalCountDownLatchstartLatch;



			   publicRun(CountDownLatchstartLatch) {

			     this.startLatch=startLatch;

			   }



			   @Override

			   publicvoidrun() {

			     try{

			       // 线程等待

			       startLatch.await();



			       // 模拟耗时操作

			       Thread.sleep(3000);



			       longendTime= System.currentTimeMillis();

			       System.out.println(Thread.currentThread().getName() +" ended at: "+endTime+", cost: "+ (endTime-startTime) +" ms.");

			     }catch(Exceptione) {

			       e.printStackTrace();

			     }



			   }

		
	}
}
