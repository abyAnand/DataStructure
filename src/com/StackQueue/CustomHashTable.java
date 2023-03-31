package com.StackQueue;

import java.util.Hashtable;
import java.util.Map;

public class CustomHashTable {

    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(100, "sponge");
        table.put(200, "bobby");

        for(Integer key : table.keySet()){
            System.out.println(key + "\t" + table.get(key));
        }

    }




}
