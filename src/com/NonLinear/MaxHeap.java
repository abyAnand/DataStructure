package com.NonLinear;

public class MaxHeap {
    private int[] Heap;
    private int size,maxsize;
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    private void swapelement(int fpos, int spos)
    {
        int tmp= Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void maxHeap(int pos)
    {
        if (Heap[pos] < Heap[leftChild(pos)]|| Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)]> Heap[rightChild(pos)]) {
                swapelement(pos, leftChild(pos));
                maxHeap(leftChild(pos));
            } else {
                swapelement(pos, rightChild(pos));
                maxHeap(rightChild(pos));
            }
        }
    }
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swapelement(current, parent(current));
            current = parent(current);
        }
    }
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(Heap[i]+ " "+Heap[2 * i]+ " "+Heap[2 * i + 1]);
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
    }
}
