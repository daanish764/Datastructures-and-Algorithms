package neetcode150.easy;

import java.util.Arrays;
import java.util.HashMap;

public class N1_TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                int firstIndex = hashMap.get(nums[i]);
                return new int[]{firstIndex, i};
            }
            hashMap.put(target-nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 15, 11, 9};
        int[] result = twoSum(nums, 26);
        System.out.println(Arrays.toString(result));

        nums = new int[]{20, 150, 1108, 989};
        result = twoSum(nums, 170);
        System.out.println(Arrays.toString(result));
    }
}
