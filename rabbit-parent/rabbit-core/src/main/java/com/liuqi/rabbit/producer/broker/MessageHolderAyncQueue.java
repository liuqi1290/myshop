package com.liuqi.rabbit.producer.broker;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

;

/**
 * @auther liuqi
 * @create 2020-12-14  16:36
 */

@Slf4j
public class MessageHolderAyncQueue {

    private static final int THREAD_SIZE=Runtime.getRuntime().availableProcessors();

    private static final int QUEUE_SIZE=1000;

    private static ExecutorService sendAsync=new ThreadPoolExecutor(
            THREAD_SIZE, THREAD_SIZE,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_SIZE),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread=new Thread(r);
                    thread.setName("BATCHSENDSYNC_MASSAGE_THREAD");

                    return thread;
                }
            },
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    log.error("send Async maggage error ! Runnable:{};executor:{}",r,executor);
                }
            });


    public static void  submit(Runnable runnable){
        sendAsync.submit(runnable);
    }
}
