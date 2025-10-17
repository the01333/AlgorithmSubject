package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_7 {
    public int reverse(int x) {
        int tmp = 0;
        long ans = 0;
        while (x != 0) {
            tmp = x % 10;
            x /= 10;
            ans = ans * 10 + tmp; 
        }
        
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new NO_7().reverse(1534236469) == 0);
        System.out.println(new NO_7().reverse(-123) == -321);
        System.out.println(new NO_7().reverse(123) == 321);
        System.out.println(new NO_7().reverse(120) == 21);
        System.out.println(new NO_7().reverse(0) == 0);
    }
}
