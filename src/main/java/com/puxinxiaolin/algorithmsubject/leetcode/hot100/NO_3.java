package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

public class NO_3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        int l = 0;
        Set<Character> set = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            
            set.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NO_3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new NO_3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new NO_3().lengthOfLongestSubstring("pwwkew"));
    }
}
