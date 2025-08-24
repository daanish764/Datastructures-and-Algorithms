package neetcode150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N347_TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // create a bucket where index is frequency
        ArrayList[] buckets = new ArrayList[nums.length+1];
        for(int i=0; i<buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }

        ArrayList<Integer> result = new ArrayList<>(k);
        for(int i=buckets.length-1; i>=0; i--) {
            ArrayList<Integer>  bucket = buckets[i];
            for(int num : bucket) {
                result.add(num);
                if(result.size() == k) break;
            }
            if(result.size() == k) break;
        }

        int[] topK = new int[k];
        for(int i=0; i<k; i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }

    

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(result));
    }
}
