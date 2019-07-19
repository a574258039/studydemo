package com.zzg.study.algorithm;

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 ? (n & (n - 1)) == 0 : false;
    }
}
