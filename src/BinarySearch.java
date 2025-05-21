public class BinarySearch {



    public static int binarySearch(int[] arr, int m, int n, int target) {

        // implement binary search.
        // arr is a sorted array in increasing order
        // function should return the index of the element that contains the target
        // and return -1 if the answer is not found.


        int mid = m + (n - m)/2;
        if(m > n) {
            return -1;
        }

        if(arr[mid] > target) {
            return binarySearch(arr, m, mid-1, target);
        }
        else if(arr[mid] < target) {
            return binarySearch(arr, mid+1, n, target);
        }
        else {
            return mid;
        }

    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 5, 8, 10, 15};
        int result = binarySearch(nums, 0, nums.length-1, 10);
        System.out.println(result); // 4

        result = binarySearch(nums, 0, nums.length-1, 12);
        System.out.println(result); // -1
    }
}