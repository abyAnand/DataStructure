package com.linkedlist;



import com.linkedlist.CustomLinkedList;

public class Main {

    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();

        int[] arr = {1,5,2,3,4,5};

        list.arrayToList(arr);


        list.removeDuplicate();
        list.display();



    }


}
