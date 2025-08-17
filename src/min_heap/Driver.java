package min_heap;

public class Driver {

    public static void main(String[] args) {
        MinHeap heap  = new MinHeap();

        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(1);
        heap.insert(9);

        System.out.println("Min: " + heap.extractMin());
        System.out.println("Min: " + heap.extractMin());
        System.out.println("Min: " + heap.extractMin());

        heap.insert(0);
        System.out.println("Min: " + heap.extractMin());
    }
}
