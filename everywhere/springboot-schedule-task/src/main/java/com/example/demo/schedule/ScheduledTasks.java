package com.example.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@EnableAsync
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 固定速率（间隔）执行，每五秒执行一次
     */
//    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWithFixedRate() {
        logger.info("current thread: {}", Thread.currentThread().getName());
        logger.info("current time：{}", dateFormat.format(new Date()));
    }

    /**
     * 固定延迟执行，距离上次成功后2秒执行
     * 由于每次执行都sleep 3秒，所以实际上是每5秒执行一次
     */
//    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTimeWithFixedDelay() {
        try {
            TimeUnit.SECONDS.sleep(3);
            logger.info("current thread: {}", Thread.currentThread().getName());
            logger.info("current time：{}", dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 固定速率（间隔）执行+初始延迟
     */
//    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void reportCurrentTimeWithFixedRateAndInitialDalay() {
        logger.info("current thread: {}", Thread.currentThread().getName());
        logger.info("current time：{}", dateFormat.format(new Date()));
    }

    /**
     * 使用Cron表达式，每分钟的1，2秒执行
     */
//    @Scheduled(cron = "1-2 * * * * ? ")
    public void reportCurrentTimeWithCronExpression() {
        logger.info("current thread: {}", Thread.currentThread().getName());
        logger.info("current time：{}", dateFormat.format(new Date()));
    }

    /**
     * 固定延迟执行，距离上次成功后2秒执行，but，是并行
     * 2秒执行一次
     */
    @Async
    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTimeWithAsyncFixedDelay() {
        try {
            TimeUnit.SECONDS.sleep(3);
            logger.info("current thread: {}", Thread.currentThread().getName());
            logger.info("current time：{}", dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
