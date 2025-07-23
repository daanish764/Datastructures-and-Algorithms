package neetcode150.easy;

import java.util.HashSet;
import java.util.Set;

public class N217_ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = new int[]{};

        nums = new int[]{2, 2};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{1, 3, 4};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{};
        System.out.println(containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
