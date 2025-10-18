package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class NO_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, target, candidates, ans, path);
        return ans;
    }

    /**
     * dfs <br/><br/>
     * 结束条件: <p>当前递归的目标和为 0, 代表找到一个结果了; 如果当前遍历的索引 = 数组长度或当前递归的目标和 < 0, 皆为非法情况</p><br/>
     * 流程: <p>分为不选和选两种走法, 如果不选让索引 + 1 并开启下次递归; 如果选, 下次递归传入的目标化和要减去当前选的这个值, 并且索引不 + 1,
     * 因为下次可能还会继续用到</p>
     *
     * @param i
     * @param target
     * @param candidates
     * @param ans
     * @param path
     */
    private void dfs(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i == candidates.length || target < 0) {
            return;
        }

        // 不选 candidates[i]
        dfs(i + 1, target, candidates, ans, path);

        // 选 candidates[i]
        path.add(candidates[i]);
        // 因为 candidates[i] 可重复使用, 可能下一次还会用到, 所以 i 不 + 1; 以及下次递归的目标和就是当前目标和 - 当前选的 candidates[i]
        dfs(i, target - candidates[i], candidates, ans, path);
        // 恢复现场
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // [[2,2,3],[7]]
        System.out.println(new NO_39().combinationSum(new int[]{2, 3, 6, 7}, 7));
        // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(new NO_39().combinationSum(new int[]{2, 3, 5}, 8));
        // []
        System.out.println(new NO_39().combinationSum(new int[]{2}, 1));
    }
}
