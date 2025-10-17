package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class NO_301 {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0, rRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lRemove++;
            } else if (s.charAt(i) == ')') {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }

        helper(s, 0, lRemove, rRemove);
        return res;
    }

    private void helper(String s, int start, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (lRemove + rRemove > s.length() - i) return;

            if (lRemove > 0 && s.charAt(i) == '(') {
                helper(s.substring(0, i) + s.substring(i + 1), i, lRemove - 1, rRemove);
            }
            if (rRemove > 0 && s.charAt(i) == ')') {
                helper(s.substring(0, i) + s.substring(i + 1), i, lRemove, rRemove - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        NO_301 solution = new NO_301();
        // ["(())()","()()()"]
        System.out.println(solution.removeInvalidParentheses("()())()"));
        // ["(a())()","(a)()()"]
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
        // [""]
        System.out.println(solution.removeInvalidParentheses(")("));
    }
}
