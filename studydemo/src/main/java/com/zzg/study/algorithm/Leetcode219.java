package com.zzg.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 */
public class Leetcode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (hash.containsKey(v)) {
                int index = hash.get(v);
                if (i - index <= k) {
                    return true;
                }
            }
            hash.put(v, i);
        }
        return false;
    }
}
