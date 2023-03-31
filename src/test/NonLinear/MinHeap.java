package test.NonLinear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap {

    List<Integer> heap = new ArrayList<>();

    public MinHeap(){

    }

    public MinHeap(List<Integer> array){
        heap = array;
        buildHeap(heap);
    }

    void buildHeap(List<Integer> array){
        for (int i = parent(heap.size()-1); i >=0 ; i--) {
            heapify(i);
        }
    }

    public void heapify(int currentIndex){
        int endIndex = heap.size()-1;
        int leftIndex = leftChild(currentIndex);
        while(leftIndex <= endIndex){
            int rightIndex = rightChild(currentIndex);
            int indexToShift;
            if(rightIndex <= endIndex && heap.get(rightIndex) < heap.get(leftIndex)){
                indexToShift = rightIndex;
            }else{
                indexToShift = leftIndex;
            }
            if(heap.get(currentIndex) < heap.get(indexToShift)){
                Collections.swap(heap, currentIndex, indexToShift);
                currentIndex = indexToShift;
                leftIndex = leftChild(currentIndex);
            }
        }
    }

    public void insert(int value){
        heap.add(value);
        shiftUp(heap.size()-1);
    }

    public void shiftUp(int currentIndex){
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

    public int parent(int i){
        return (i-1)/2;
    }

    public int leftChild(int i){
        return (2*i) + 1;
    }

    public int rightChild(int i){
        return (2*i) + 2;
    }

}
