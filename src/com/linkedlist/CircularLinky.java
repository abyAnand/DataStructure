package com.linkedlist;

public class CircularLinky {

    private Node head;
    private Node tail;

    public CircularLinky(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display(){

        Node node = head;
        if(head != null){
            do{
                System.out.print(node.val + "-> ");
                node = node.next;
            }while(node != head); // or while(node != tail);
            System.out.println("HEAD");
        }

    }

    void displayWithWhileLoop(){
        Node temp = head;
        if (head == null){
            System.out.println("Empty");
        }else{
            while(temp.next != temp){
                System.out.print(temp.val+"->");
                temp = temp.next;
            }
            System.out.print(temp.val+"->END\n");
        }
    }

    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.val == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if(n.val == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node != head);
    }



    private class Node{

        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
