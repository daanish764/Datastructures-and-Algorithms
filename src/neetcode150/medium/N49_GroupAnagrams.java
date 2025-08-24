package neetcode150.medium;

import java.util.*;

public class N49_GroupAnagrams {

    public static List<List<String>> groupAnagram(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String s : strs) {
            int[] freq = new int[26];

            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for(int j=0; j<26; j++) {
                if(freq[j] > 0) {
                    keyBuilder.append((char)(j + 'a')).append(freq[j]).append('#');
                }
            }

            String key = keyBuilder.toString();
            hashMap.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[6];
        strs[0] = "eat";
        strs[1] = "tea";
        strs[2] = "tan";
        strs[3] = "ate";
        strs[4] = "nat";
        strs[5] = "bat";

        List<List<String>> result = groupAnagram(strs);

        result.forEach((x) -> {
            for(String s : x) {
                System.out.print(s+"\t");
            }
            System.out.println();
        });

    }
}
