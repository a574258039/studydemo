package com.zzg.study.test.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/20
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class ProducerCustomer04 {
    public static int MAX = 10;
    public static int size = 0;

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition full = lock.newCondition();

        Thread t = new Thread(new Producer04(notFull, full, "P1"));
        Thread t4 = new Thread(new Producer04(notFull, full, "P2"));
        Thread t3 = new Thread(new Producer04(notFull, full, "P3"));
        Thread t2 = new Thread(new Customer04(notFull, full, "C1"));
        t.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Producer04 implements Runnable {

    Logger log = Logger.getLogger("Producer");
    private Condition notFull;
    private Condition full;
    private String name;

    public Producer04(Condition notFull, Condition full, String name) {
        this.notFull = notFull;
        this.full = full;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                while (ProducerCustomer04.size > ProducerCustomer04.MAX) {
                    full.await();
                }
                ProducerCustomer04.size++;
                log.info(name + "生产了1个，剩下" + ProducerCustomer04.size + "个");
                notFull.signal();
            } catch (Exception e) {
            }
        }
    }
}

class Customer04 implements Runnable {
    Logger log = Logger.getLogger("Customer04");
    private Condition notFull;
    private Condition full;
    private String name;

    public Customer04(Condition notFull, Condition full, String name) {
        this.notFull = notFull;
        this.full = full;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                while (ProducerCustomer04.size <= 0) {
                    notFull.await();
                }
                ProducerCustomer04.size--;
                log.info(name + "生产了1个，剩下" + ProducerCustomer04.size + "个");
                full.signal();
            } catch (Exception e) {
            }
        }
    }
}