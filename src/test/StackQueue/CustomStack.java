package test.StackQueue;

public class CustomStack {

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;


    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){

        if(isFull()){
            System.out.println("Stack is Full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot Pop from an empty stack");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek()throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot Peek from an empty stack");
        }

        return data[ptr];
    }

    public void display(){
        for (int i = 0; i <= ptr; i++) {
            System.out.println(data[i]);
        }
    }

    boolean isFull(){
        return ptr==data.length -1;
    }

    private boolean isEmpty(){
        return ptr== -1;
    }
}
