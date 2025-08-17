package min_heap;

import java.util.ArrayList;

public class MinHeap {

    private final ArrayList<Integer> heap;

    MinHeap() {
        heap = new ArrayList<>();
    }

    public int getLeftIndex(int i) {
        return 2*i+1;
    }

    public int getRightIndex(int i) {
        return 2*i+2;
    }

    public int getParentIndex(int i) {
        return (i-1)/2;
    }

    public boolean hasLeftChild(int i) {
        return getLeftIndex(i) < heap.size();
    }

    public boolean hasRightChild(int i) {
        return getRightIndex(i) < heap.size();
    }

    public boolean hasParent(int i) {
        return getParentIndex(i)>=0;
    }


    public void insert(int val) {
        heap.add(val);
        heapifyUp();
    }

    public void heapifyUp() {
        int current = heap.size()-1;

        while(hasParent(current) && heap.get(current) < heap.get(getParentIndex(current)))  {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
    }

    public int extractMin() {
        if(heap.isEmpty()) { throw new RuntimeException("Heap is empty"); };
        int result = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        heapifyDown();
        return result;
    }


    public void heapifyDown() {
        int current = 0;

        while(hasLeftChild(current)) {
            int smallestChild = getLeftIndex(current);
            if(hasRightChild(current) && heap.get(getRightIndex(current)) < heap.get(smallestChild)) {
                smallestChild = getRightIndex(current);
            }
            if(heap.get(current) < heap.get(smallestChild)) {
                break;
            }

            swap(current, smallestChild);
            current = smallestChild;

        }
    }


    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


}
