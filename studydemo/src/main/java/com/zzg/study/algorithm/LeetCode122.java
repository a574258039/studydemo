package com.zzg.study.algorithm;

/**
 * 买卖股票的最佳时机 II  贪心算法
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {

        int max = 0;
        if (prices == null) {
            return max;
        }
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
