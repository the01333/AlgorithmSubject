package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.*;

public class NO_347 {
    public int[] topKFrequent(int[] nums, int k) {
//        return javaApi(nums, k);

        return bucks(nums, k);
    }

    /**
     * <p>桶排序</p><br/>
     * 1. 先统计各元素出现次数 <br/>
     * 2. 再把相同次数的元素放到一个桶里 <br/>
     * 3. 倒序遍历桶，找到前 k 个元素 <br/>
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] bucks(int[] nums, int k) {
        // 1. 统计出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int maxCnt = Collections.max(cnt.values());

        // 2. 出现次数相同的元素放到一个桶里
        List<Integer>[] bucks = new ArrayList[maxCnt + 1];
        Arrays.setAll(bucks, i -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            bucks[entry.getValue()].add(entry.getKey());
        }

        // 3. 倒序遍历桶，找到前 k 个元素
        int[] ans = new int[k];
        // 用 j 来维护当前添加的是前 k 个元素里的第几个元素
        for (int i = maxCnt, j = 0; i >= 0 && j < k; i--) {
            for (Integer num : bucks[i]) {
                ans[j++] = num;
            }
        }
        return ans;
    }

    /**
     * 用 stream-api 解决
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] javaApi(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .mapToInt(Map.Entry::getKey)
                .limit(k)
                .toArray();
    }

    public static void main(String[] args) {
        // [1, 2]
        System.out.println(Arrays.toString(new NO_347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        // [1]
        System.out.println(Arrays.toString(new NO_347().topKFrequent(new int[]{1}, 1)));
        // [1, 2]
        System.out.println(Arrays.toString(new NO_347().topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)));
    }
}
