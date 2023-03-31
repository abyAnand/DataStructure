package com.linkedlist;

public class CustomDoubly {

    Node head;
    Node tail;

    int size =0;

    public CustomDoubly(){
        this.size = 0;
    }



    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

public void arrayToDoubly(int[] array){
        Node head = null;
        Node tail = null;
        for(int number : array){
            if(head == null){
                head = new Node(number);
                tail = head;
            }
            else{
                Node node = new Node(number);
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
        this.head = head;
}



    public void display(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.value+"-> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in Reverse");
        while(last != null){
            System.out.print(last.value+"-> ");
            last = last.prev;
        }

        System.out.println("START");
    }

    public void insertLast(int val){

        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }


    public void insert(int after, int val){
        Node p = find(after);

        if(p == null){
            System.out.println("Does Not Exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }

    }

    public void insert(int value) {
        insertLast(value);
    }

    public void insertBefore(int before, int val) {
        Node p = find(before);

        if (p == null) {
            System.out.println("Does Not Exist");
            return;
        }

        Node node = new Node(val);
        node.prev = p.prev;
        node.next = p;

        if (p.prev == null) {
            head = node;
        } else {
            p.prev.next = node;
        }

        p.prev = node;
    }


    public void delete(int val) {
        Node node = find(val);
        if (node == null) {
            System.out.println("Value does not exist in list");
            return;
        }
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
    }

    public void insertAfter(Node prevNode, int val) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(val);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        size++;
    }



    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int val){
            this.value = val;
        }

        public Node(int val, Node next, Node prev) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
