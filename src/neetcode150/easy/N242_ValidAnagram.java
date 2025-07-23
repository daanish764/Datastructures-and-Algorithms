package neetcode150.easy;

import java.util.HashMap;

public class N242_ValidAnagram {

    public static boolean isAnagram(String s, String t){

        if(s.length() != t.length()) return false;


        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()) {
            Integer count = hashMap.get(c);

            if(count == null) return false;

            if(count == 1) {
                hashMap.remove(c);
            }
            else {
                hashMap.put(c, count-1);
            }
        }

        return hashMap.isEmpty();
    }


    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));

    }

}
