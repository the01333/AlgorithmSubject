package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NO_406 {
    public int[][] reconstructQueue(int[][] people) {
        // 对身高降序排序, 对前面排队人数升序排序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        // 利用 linkedList 的特性来自动解决插入时的移动问题
        List<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        System.out.println(Arrays.deepToString(new NO_406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
        // [[4, 0], [5, 0], [2, 2], [3, 2], [1, 4], [6, 0]]
        System.out.println(Arrays.deepToString(new NO_406().reconstructQueue(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}})));
    }
}
