package com.zzg.study.algorithm;

import java.util.Stack;

/**
 * 155. 最小栈
 * <p>
 * 题目描述
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class LeetCode155 {

    public static void main(String[] args) {
        MinStack t = new MinStack();
        t.push(2147483647);
        t.push(-2147483648);
        System.out.printf("" + t);
    }


}

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(minStack.isEmpty() || minStack.peek() >= x ? minStack.push(x) : x);
    }

    public void pop() {
        if (!minStack.isEmpty() && stack.pop().intValue() == minStack.peek().intValue()) {
            minStack.pop();
        }
    }

    public int top() {
//        if (!minStack.isEmpty()) {
//            return stack.peek() - minStack.peek() == 0 ? minStack.pop() : stack.pop();
//        }
        return minStack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }


}


class MinStack2 {

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

