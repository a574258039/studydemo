package com.zzg.study.test.demo1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/19
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class ProducerCustomer01 {
    public static int capacity = 0;
    public static int size = 10;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread producer = new Thread(new Producer(lock, "P1"));
        Thread producer2 = new Thread(new Producer(lock, "P2"));
        Thread customer = new Thread(new Customer(lock, "c1"));
        Thread customer2 = new Thread(new Customer(lock, "c2"));
        producer.start();
        producer2.start();
        customer.start();
        customer2.start();

    }

}

/* 生产者 */
class Producer implements Runnable {

    Logger log = Logger.getLogger("Producer");

    private String name = null;
    private Object lock = null;

    public Producer(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {


        while (true) {

            synchronized (lock) {
                while (ProducerCustomer01.capacity > ProducerCustomer01.size) {
                    try {
                        log.info(name + "资本家休息会");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info(name + "资本家生产者开始套路：i=" + ProducerCustomer01.capacity);
                ProducerCustomer01.capacity++;
                log.info(name + "资本家生产者开始套路完了，等韭菜");
                lock.notifyAll();

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/* 消费者 */
class Customer implements Runnable {

    Logger log = Logger.getLogger("Customer");

    private String name = null;
    private Object lock = null;

    public Customer(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            synchronized (lock) {
                while (ProducerCustomer01.capacity <= 0) {
                    try {
                        log.info(name + "韭菜们休息一会");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info(name + "欢快的韭菜们开始消费：i=" + ProducerCustomer01.capacity);
                ProducerCustomer01.capacity--;
                log.info(name + "欢快的韭菜们开始消费完了。");
                lock.notifyAll();
            }
        }
    }
}
