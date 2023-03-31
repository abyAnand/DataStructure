package com.NonLinear;

import java.util.*;

public class MinHeap {

    List<Integer> heap = new ArrayList<>();

    public MinHeap(){

    }

    public MinHeap(List<Integer> array){

        buildHeap(array);
    }

    public void buildHeap(List<Integer> array){
        heap = array;
        for (int i = parent(heap.size() -1); i >=0; i--) {
            heapify(i);
        }
    }

    private void heapify(int currentIndex){
        int endIndex = heap.size()-1;
        int leftIndex = leftChild(currentIndex);
        while(leftIndex <= endIndex){
            int rightIndex = rightChild(currentIndex);
            int indexToShift;
            if(rightIndex <= endIndex && heap.get(rightIndex)< heap.get(leftIndex)){
                indexToShift = rightIndex;
            }else{
                indexToShift = leftIndex;
            }
            if(heap.get(currentIndex) > heap.get(indexToShift)){
                Collections.swap(heap, currentIndex, indexToShift);
                currentIndex = indexToShift;
                leftIndex = leftChild(currentIndex);
            }else{
                return;
            }
        }
    }

    private void shiftUp(int currentIndex){
        int parentIndex = parent(currentIndex);
        while(currentIndex > 0 && heap.get(parentIndex) > heap.get(currentIndex)){
            Collections.swap(heap, currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parent(currentIndex);
        }
    }

    public int peek(){
        return heap.get(0);
    }

    public void remove(){
        Collections.swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        heapify(0);
    }

    public void insert(int value){
        heap.add(value);
        shiftUp(heap.size()-1);
    }

    private int parent(int i){
        return (i-1) /2;
    }

    private int leftChild(int i){
        return (i*2) +1;
    }
    private int rightChild(int i){
        return (i*2) + 2;
    }

    public void display(){
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap.get(i));
        }
    }

    public void displaySb(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heap.size(); i++) {
            sb.append(heap.get(i)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,3,4));
        MinHeap heap = new MinHeap(array);
        heap.displaySb();
    }
}
