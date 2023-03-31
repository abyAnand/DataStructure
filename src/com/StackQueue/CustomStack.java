package com.StackQueue;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){

        if(isFull()){
            System.out.println("Stack is Full!!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot Pop from an Empty stack!!!");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek()throws CustomStackException{
        if(isEmpty()){
            throw new CustomStackException("Cannot peek from an Empty stack!!!");
        }
        return data[ptr];
    }

    private boolean isFull() {
        return ptr == data.length -1; // pointer is at last index.
    }

    private boolean isEmpty(){
        return ptr== -1; //
    }
}
