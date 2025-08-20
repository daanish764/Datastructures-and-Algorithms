package neetcode150.easy;

// space O(1)
// time O(n)

public class N136_SingleNumber {

    public static int singleNumber(int[] nums) {

        int result = 0;

        for(int i=0; i<nums.length; i++){
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
