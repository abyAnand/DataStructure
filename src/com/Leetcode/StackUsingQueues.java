package com.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

//Implement a last-in-first-out (LIFO) stack using only two queues.
//The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
    }
}
class MyStack {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public void pop() {
        queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}