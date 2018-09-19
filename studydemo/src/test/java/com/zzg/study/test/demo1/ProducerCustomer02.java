package com.zzg.study.test.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/19
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class ProducerCustomer02 {
    public static int capacity = 0;
    public static int size = 10;

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition nullFll = lock.newCondition();
        Condition fll = lock.newCondition();

        Thread p = new Thread(new ProducerLock(nullFll, fll, lock, "P1"));
        Thread p2 = new Thread(new ProducerLock(nullFll, fll, lock, "P2"));
        Thread p3 = new Thread(new ProducerLock(nullFll, fll, lock, "P3"));
        Thread p4 = new Thread(new ProducerLock(nullFll, fll, lock, "P4"));
        Thread c = new Thread(new CustomerLock(nullFll, fll, lock, "c1"));
        c.start();
        p.start();
        p2.start();
        p3.start();
        p4.start();

    }


}

class ProducerLock implements Runnable {

    Logger log = Logger.getLogger("Producer");
    private Condition fll = null;
    private Condition notFll = null;
    private Lock lock = null;
    private String name = null;

    public ProducerLock(Condition notFll, Condition fll, Lock lock, String name) {
        this.notFll = notFll;
        this.fll = fll;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                lock.lock();
                while (ProducerCustomer02.capacity > ProducerCustomer02.size) {
                    fll.wait();
                }
                ProducerCustomer02.capacity++;
                log.info(name + "生产中...,capacity=###" + ProducerCustomer02.capacity);
                notFll.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }
}

class CustomerLock implements Runnable {
    Logger log = Logger.getLogger("CustomerLock");
    private Condition fll = null;
    private Condition notFll = null;
    private Lock lock = null;
    private String name = null;

    public CustomerLock(Condition notFll, Condition fll, Lock lock, String name) {
        this.notFll = notFll;
        this.fll = fll;
        this.lock = lock;
        this.name = name;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                lock.lock();
                while (ProducerCustomer02.capacity <= 0) {
                    notFll.wait();
                }
                ProducerCustomer02.capacity--;
                log.info(name + "消费中...,capacity=###" + ProducerCustomer02.capacity);
                fll.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }
}

