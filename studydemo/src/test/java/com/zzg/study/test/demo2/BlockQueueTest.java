package com.zzg.study.test.demo2;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/26
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class BlockQueueTest {


    Logger log = Logger.getLogger("BlockQueueTest");

    private BlockingQueue<String> queue=new ArrayBlockingQueue<String>(10);
    private static int i=0;


    @Test
    public void test() throws InterruptedException {

        String p1s = "P1-";

        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    i++;
                    try {
                        Thread.sleep(1000);
                        log.info(p1s + "将i=" + i + "放入队列");
                        queue.put(p1s + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        String c1s = "C1-";
        Thread c1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        String value=queue.take();
                        log.info(c1s+"从队列获取到value="+value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        String c2s = "C2-";
        Thread c2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        String value=queue.take();
                        log.info(c2s+"从队列获取到value="+value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        p1.start();
        //c1.start();
        //c2.start();

    }
}
