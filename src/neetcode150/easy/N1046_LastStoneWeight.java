package neetcode150.easy;

import java.util.PriorityQueue;

public class N1046_LastStoneWeight {

    // space: O(n)
    // time: O(nlogn)

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

        // O(n)
        for(int stone : stones) {
            maxHeap.add(stone);
        }

        // O(nlogn)
        // because we can have n-1 poll calls
        // and n-1 add calls
        // and each call will heapifyUp which is O(logn)
        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first != second) {
                int diff = Math.abs(first - second);
                maxHeap.add(diff);
            }
        }

        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
