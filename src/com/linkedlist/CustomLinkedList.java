package com.linkedlist;

import java.util.HashSet;
import java.util.Map ;
import java.util.Set;

public class CustomLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public CustomLinkedList(){

        this.size = 0;
    }

    public void arrayToList(int[] array){
        for(int number : array){
            insertLast(number);
        }
    }


    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = node;
        }

        size += 1;
    }

    public void insertLast(int val){
        //means list is empty
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertBefore(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = getNode(index - 1);
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertAfter(int val, int index) {
        if (index == size - 1) {
            insertLast(val);
            return;
        }
        Node temp = getNode(index);
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void removeAdjacentDuplicate(){

        Node current = head;
        while(current != null && current.next != null){
            if(current.next.value == current.value){
                current.next = current.next.next;
                size--;
            }
            else{
                current = current.next;
            }
        }

    }


    //Not readable
//    public void removeDuplicate(){
//        Node current = head;
//        Set<Integer> set = new HashSet<>();
//        set.add(current.value);
//        while(current.next != null){
//            if(set.contains(current.next.value)){
//                current.next = current.next.next;
//            }else{
//                set.add(current.next.value);
//                current = current.next;
//            }
//        }
//    }

    public void removeDuplicate(){
        Node current = head;
        Node previous = null;
        Set<Integer> set = new HashSet<>();
        while(current != null){
            //if the set has the value
            if(set.contains(current.value)){
                previous.next = current.next;
                size--;
            }else{
                set.add(current.value);
                previous = current;
            }

            //for looping
            current = current.next;
        }
    }

    public void reverse(){
        Node prev = null;

        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
            if(prev == null)
                System.out.println("EMPTY");
            Node temp = prev;
            while (temp != null) {

                System.out.print(temp.value + "->");
                temp = temp.next;
            }
            System.out.println("END");

    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        if(index< size){
            for (int i = 1; i < index; i++) {
                //at the loop end the temp will have the addr of the next node after the inserted node;
                temp = temp.next;
            }

            Node node = new Node(val, temp.next);
            temp.next = node;
            size++;
        }
        else{
            System.out.println("Given position exceeded the arraylist size");
        }


    }

    public void insert(int val){
        insertLast(val);

    }



    public int deleteLast() {
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size -1){
            return deleteLast();
        }

        Node prev = getNode(index -1);
        int val = prev.next.value;

        //assigning the value of the next node after the deleting node
        prev.next = prev.next.next;

        return val;

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

    public Node getNode(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null)
            tail = null;
        size--;
        return val;
    }


    int linkedSum =0;

    public void display(){
        if(head == null)
            System.out.println("EMPTY");
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void sumOfAll(){
        if(head == null)
            System.out.println("EMPTY");
        Node temp = head;
        while(temp != null){
             linkedSum += temp.value;
            temp = temp.next;
        }
        System.out.println(linkedSum);
    }

    private class Node{

        private int value;
        private Node next;


        public Node(int value){

            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }


    }

}
