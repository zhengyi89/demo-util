package com.test.quartz;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Quartz是一个强大任务调度框架
 * 
 * @author zhengy
 * @date: 2019年2月28日 上午9:45:16
 */
public class QuartzTest {
	@Test
	public void test1() throws SchedulerException {
		
	}

	public static void main(String[] args) throws SchedulerException {
		// 创建一个jobDetail的实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();
		// 创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
		SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
		// 创建schedule实例
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
