package com.Leetcode;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        System.out.println(myQueue.peek());
        myQueue.pop();
        myQueue.pop();
     //   myQueue.pop();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }

}
class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}