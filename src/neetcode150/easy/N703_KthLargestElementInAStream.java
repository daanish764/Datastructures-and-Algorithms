package neetcode150.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N703_KthLargestElementInAStream {

    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>((a,b) -> a - b);
            this.k = k;
            for(int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }


    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

    }
}
