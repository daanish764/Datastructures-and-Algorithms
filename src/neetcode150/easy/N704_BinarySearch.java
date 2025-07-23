package neetcode150.easy;

public class N704_BinarySearch {


    public static int search(int[] nums, int left, int right, int target) {
        int mid = left + (right-left)/2;

        if(left > right) {
            return -1;
        }

        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            // the number is on the right
            return search(nums, mid+1, right, target);
        }
        else if(nums[mid] > target) {
            // the number is on the left
            return search(nums, left, mid-1, target);
        }

        return -1;
    }


    public static int search(int[] nums, int target) {

        return search(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 3));

        nums = new int[]{};
        System.out.println(search(nums, 9000));
    }


}
