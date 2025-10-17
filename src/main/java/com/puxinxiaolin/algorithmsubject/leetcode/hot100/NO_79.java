package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_79 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int idx) {
        // 字符不匹配
        if (board[i][j] != word.charAt(idx)) return false;
        // 匹配完成
        if (idx == word.length() - 1) return true;
        
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (!visited[ni][nj]) {
                    // 基于当前的新坐标继续递归看是否能找到下一个字符
                    boolean flag = check(board, visited, ni, nj, word, idx + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        
        // 还原现场
        visited[i][j] = false;
        return res;
    }
}
