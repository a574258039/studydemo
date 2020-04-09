package com.zzg.study.algorithm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class LeetCode232 {

    public static void main(String[] args) {
//        Map<Integer, AtomicInteger> symbolCounter = new HashMap<>();
//
//        symbolCounter.put(0,new AtomicInteger());
//        for(int i=0;i<100;i++){
//            symbolCounter.get(0).incrementAndGet();
//        }
//        symbolCounter.get(0).decrementAndGet();
//        System.out.printf(""+symbolCounter);
//
//
//
//        LinkedBlockingQueue<String> String=new LinkedBlockingQueue<String>();
//        String.add("1");
//        String.add("2");
//        String.add("3");
//        String.add("4");
////
////        LinkedBlockingQueue<String> String2=new LinkedBlockingQueue<String>();
////        String.drainTo(String2,1);
////        String.drainTo(String2,2);
//
//
//
//
//        Optional<String> res=String.stream().filter(key->key.equals("3")).findFirst();
//        Optional<String> res2=String.stream().filter(key->key.equals("10")).findAny();
//
//        System.out.printf(""+res);

//        LinkedList<String> list=new LinkedList<>();
//        list.forEach(key-> System.out.printf(""+key));

        int status = -1 << 2;
        System.out.printf("" + status);


    }

}
