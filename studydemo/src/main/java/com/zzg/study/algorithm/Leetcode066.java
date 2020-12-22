package com.zzg.study.algorithm;

/**
 * 加1
 */
public class Leetcode066 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] != 10) {
                break;
            }
            digits[i] = digits[i] % 10;
            if (i == 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
