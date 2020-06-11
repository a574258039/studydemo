package com.zzg.study.test.demo1;

import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/20
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class ProducerCustomer03 {
    public static int MAX = 10;
    public static int size = 0;

    public static void main(String[] args) {
        Object object = new Object();
        Thread t = new Thread(new Producer03("P1", object));
        Thread t4 = new Thread(new Producer03("P3", object));
        Thread t3 = new Thread(new Producer03("P2", object));
        Thread t2 = new Thread(new Customer03("C1", object));
        t.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class Producer03 implements Runnable {
    Logger log = Logger.getLogger("Producer");
    private String name = null;
    private Object lock = null;


    public Producer03(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
                while (ProducerCustomer03.size >= ProducerCustomer03.MAX) {
                    lock.wait();
                }
                ProducerCustomer03.size++;
                log.info(name + "生产了1个，剩下" + ProducerCustomer03.size + "个");
                log.notifyAll();
            } catch (Exception e) {

            }
        }

    }
}

class Customer03 implements Runnable {

    Logger log = Logger.getLogger("Customer03");

    private String name = null;
    private Object lock = null;

    public Customer03(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                while (ProducerCustomer03.size <= 0) {
                    lock.wait();
                }
                ProducerCustomer03.size--;
                log.info(name + "消费了1个，剩下" + ProducerCustomer03.size + "个");
                log.notifyAll();
            } catch (Exception e) {
            }
        }
    }
}
