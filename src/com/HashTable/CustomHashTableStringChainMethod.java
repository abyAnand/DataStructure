package com.HashTable;
//String key hashing
public class CustomHashTableStringChainMethod {

    private int size;
    private Node[] table;

    public CustomHashTableStringChainMethod(int size) {
        this.size = size;
        table = new Node[size];
//        for (int i = 0; i < size; i++) {
//            table[i] = null;
//        }
    }

    public void put(String key, String value) {
        int hash = hash(key);
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
    public int hash(String key){
        int hash=0;
        for (int i = 0; i <key.length() ; i++) {
            //multiplying with 31 (odd prime number) is optional, it helps to avoid collisions.
            hash = (hash + 31 * key.charAt(i)) % size;
        }
        return hash;
    }

    public String get(String key) {
        int hash =hash(key);
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
    public void delete(String key){
        int hash = hash(key);

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
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CustomHashTableStringChainMethod ht = new CustomHashTableStringChainMethod(10);
        ht.put("1", "value1");
        ht.put("15", "value2");
        ht.put("25", "value3");
        ht.delete("1");
        ht.delete("25");
        System.out.println(ht.get("1"));
        System.out.println(ht.get("15"));
        System.out.println(ht.get("25"));

    }
}
