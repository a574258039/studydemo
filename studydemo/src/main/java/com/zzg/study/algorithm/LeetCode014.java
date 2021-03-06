package com.zzg.study.algorithm;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LeetCode014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonStr = strs[0];
        String minStr = commonStr;
        boolean same = true;
        while (commonStr.length() > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < commonStr.length() || !strs[i].startsWith(commonStr)) {
                    minStr = strs[i];
                    same = false;
                    break;
                }
            }
            if (!same) {
                commonStr = minStr.length() < commonStr.length() ? minStr : commonStr.substring(0, commonStr.length() - 1);
                same = !same;
                continue;
            }
            break;
        }
        return commonStr;
    }
}
