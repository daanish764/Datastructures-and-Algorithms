package neetcode150.easy;

import java.util.Arrays;

public class N66_PlusOne {

    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]+=1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }


        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits;

        digits = new int[]{9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
