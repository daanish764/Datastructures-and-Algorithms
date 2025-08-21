package neetcode150.easy;

import java.util.HashSet;
import java.util.Set;

public class N202_HappyNumber {

    public static boolean isHappy(int num) {

        Set<Integer> visited = new HashSet<>();

        while(!visited.contains(num)) {
            visited.add(num);
            num = sumOfSquares(num);
        }

        return num==1;
    }

    public static int sumOfSquares(int num) {
        int result = 0;
        while(num>0) {
            result += (num%10)*(num%10);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
         System.out.println(isHappy(2));


    }
}
