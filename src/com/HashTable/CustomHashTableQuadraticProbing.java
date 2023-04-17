package com.HashTable;

public class CustomHashTableQuadraticProbing {
    private class Node {
        int key;
        String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private Node[] table;

    public CustomHashTableQuadraticProbing(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    public int put(int key, String value) {
        int hash = key % size;
        int probes = 1;

        if (table[hash] == null || table[hash].key == key) {
            table[hash] = new Node(key, value);
        } else {
            int i = 1;
            while (i < size) {
                int index = (hash + i * i) % size;

                if (table[index] == null || table[index].key == key) {
                    table[index] = new Node(key, value);
                    break;
                }

                i++;
                probes++;
            }

            if (i == size) {
                System.out.println("Not able to insert");
            }
        }

        return probes;
    }

    public String get(int key) {
        int hash = key % size;

        if (table[hash] != null && table[hash].key == key) {
            return table[hash].value;
        } else {
            int i = 1;
            while (i < size) {
                int index = (hash + i * i) % size;

                if (table[index] != null && table[index].key == key) {
                    return table[index].value;
                }

                i++;
            }

            return "Not Found";
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println("Key: " + table[i].key + " Value: " + table[i].value);
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        CustomHashTableQuadraticProbing table = new CustomHashTableQuadraticProbing(10);
        table.put(1, "Hello");
        table.put(2, "Hello2");
        table.put(3, "Hello3");
        table.put(15, "Hello15");
        table.put(25, "Hello25");

        table.printTable();
        System.out.println(table.get(25));
    }
}

