package com.zzg.study.test.demo1;

import java.util.logging.Logger;

/**
 * Created user :zhangzhigang5
 * Created date :2018/9/21
 * Created desc :
 * Created whit :@jdpay
 * Created tips :details determine success or failure
 */
public class BlockQueue {

    static Logger log = Logger.getLogger("BlockQueue");
    private Node head;
    private Node tail;
    private int size;
    private int maxSize = 10;

    public static void main(String[] args) {
        final BlockQueue blockQueue = new BlockQueue();

//        blockQueue.put("1");
//        blockQueue.put("2");
//        blockQueue.put("3");
//        String v1=blockQueue.get();
//        log.info("v1="+v1);
//        String v2=blockQueue.get();
//        log.info("v2="+v2);
//        String v3=blockQueue.get();
//        log.info("v3="+v3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    try {
                        blockQueue.put("P" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        blockQueue.put("2P" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    String s = null;
                    try {
                        s = blockQueue.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("--->" + s);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }


    public void put(String value) throws InterruptedException {

        synchronized (this) {
            Thread.sleep(1000);
            while (size >= maxSize) {
                this.wait();
            }
            size++;
            if (head == null) {
                head = new Node(value);
                tail = head;
                head.next = tail;
            } else {
                Node node = new Node(value);
                tail.next = node;
                node.prec = tail;
                tail = node;
            }
            log.info(value + "进入队列size=" + size);

        }
    }

    public String get() throws InterruptedException {
        String value = null;
        Thread.sleep(1000);
        synchronized (this) {

            if (tail == null || size == 0) {
                this.wait();
            }
            if (tail == null || tail == head) {
                value = head.value;
                tail = head = null;
            } else {
                value = tail.value;
                Node tmp = tail.prec;
                tmp.next = null;
                tail = tmp;
            }

            size--;
            log.info(value + "出队列size=" + size);
            this.notifyAll();
        }
        return value;
    }


    class Node {
        /* 下一个节点 */
        private Node next;
        /* 上一个节点 */
        private Node prec;
        /* 值 */
        private String value;

        public Node(String value) {
            this.value = value;
        }
    }
}


