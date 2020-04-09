package com.zzg.study.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode020 {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Map<Character, Character> type = new HashMap();
        type.put('(', ')');
        type.put('{', '}');
        type.put('[', ']');
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (characters.isEmpty()) {
                characters.push(chars[i]);
                continue;
            }
            Character index = type.get(characters.peek());
            if ((index == null || chars[i] != index)) {
                characters.push(chars[i]);
                continue;
            }
            characters.pop();
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        Boolean result = new LeetCode020().isValid("()()()[]");
        System.out.printf("" + result);


    }
}
