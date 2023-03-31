package com.StackQueue;

public class StackMain {
    public static void main(String[] args) throws CustomStackException {
        CustomStack stack = new CustomStack(5);

        stack.push(34);
        stack.push(35);
        stack.push(36);
        stack.push(37);
        stack.push(38);


        System.out.println(stack.pop());
    }
}
