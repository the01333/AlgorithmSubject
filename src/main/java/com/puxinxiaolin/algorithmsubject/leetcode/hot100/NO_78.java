package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class NO_78 {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        
        return ans;
    }

    private void dfs(int[] nums, int idx, List<Integer> tmp) {
        // 添加空集
        ans.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, i + 1, tmp);
            // 还原现场
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        System.out.println(new NO_78().subsets(new int[]{1, 2, 3}));
        // [[], [0]]
        System.out.println(new NO_78().subsets(new int[]{0}));
    }
}
