package com.HashTable;
//Collision handling using chain method aka Closed addressing

public class CustomHashTableChainMethod {

    private int size;
    private Node[] table;

    public CustomHashTableChainMethod(int size) {
        this.size = size;
        table = new Node[size];
//        for (int i = 0; i < size; i++) {
//            table[i] = null;
//        }
    }

    public void put(int key, String value) {
        int hash = key % size;
        if (table[hash] == null || table[hash].key==key) {
            table[hash] = new Node(key, value);
        } else {
            Node entry = table[hash];
            while (entry.next != null && entry.key != key) {
                entry = entry.next;
            }
            if (entry.key == key) {
                entry.value = value;
            } else {
                entry.next = new Node(key, value);
            }
        }
    }

    public String get(int key) {
        int hash = key % size;
        if (table[hash] == null) {
            return null;
        } else {
            Node entry = table[hash];
            while (entry != null && entry.key != key) {
                entry = entry.next;
            }
            if (entry == null) {
                return null;
            } else {
                return entry.value;
            }
        }
    }
    public void delete(int key){
        int hash = key % size;

        if (table[hash].key == key){
            table[hash] = table[hash].next;
        }
        else{
            Node current = table[hash];
            Node prev = null;
            while (current != null && current.key != key) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                System.out.println("Not Found");
            }
            if (current.key == key) {
                if (current.next != null) {
                    prev.next = current.next;
                } else {
                    prev.next = null;
                }
            }
        }
    }

    private class Node {
        int key;
        String value;
        Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CustomHashTableChainMethod ht = new CustomHashTableChainMethod(10);
        ht.put(1, "value1");
        ht.put(15, "value2");
        ht.put(25, "value3");
        ht.delete(1);
        ht.delete(25);
        System.out.println(ht.get(1));
        System.out.println(ht.get(15));
        System.out.println(ht.get(25));

    }
}