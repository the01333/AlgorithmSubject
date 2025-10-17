package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

import java.util.*;

public class NO_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个节点的入度值
        int[] indegrees = new int[numCourses];
        // 初始化邻接表
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // 填充入度值（这里题目限制数组大小为 2）
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            // 走第一个要先走第二个 [0, 1] ==> 1 -> 0
            graph.get(preCourse).add(course);
            // 入度值 + 1
            indegrees[course]++;
        }

        // 用队列来拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        // 把头部节点（入度为 0）加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        
        // 已经完成的课程数
        int count = 0;
        // 拓扑排序
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;

            for (Integer next : graph.get(cur)) {
                indegrees[next]--;
                // 如果入度为 0, 表示可以开始学, 加入队列
                if (indegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new NO_207().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(!new NO_207().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
