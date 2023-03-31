package test.StackQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        CustomQueue queue = new CustomQueue();

        queue.insert(55);
        queue.insert(225);
        queue.insert(234);
        queue.display();
        queue.remove();
        System.out.println("After removing");
        queue.display();

    }
}
