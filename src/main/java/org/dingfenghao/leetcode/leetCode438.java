package org.dingfenghao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingfenghao
 */
public class leetCode438 {

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     */


    /**
     * 解题思路:
     * 要求我们从 s 中找到所有是 p 的异位词的子串。所谓异位词就是字符串字符种类均相同但顺序可以不同的两个子串，
     * 那么首先就要先统计字符串 p 中的字符出现的次数，然后依次从字符串 s 中取出 p 字符串长度的子串进行比较，
     * 如果 s 子串中的每一个字符都在 p 字符串中出现，那么就记录当前子串的起始位置，否则 break 当前循环。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        int[] hash = new int[256];
        for (char i : p.toCharArray()) {
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();

        while (right < s.length()){
            // 窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，
            // 表示当前字符包含在 p 字符串中，所以差异度减一
            if(hash[s.charAt(right)] >0){
                count --;
            }
            hash[s.charAt(right)]--;
            right ++;

            // 差异度为0，加入结果集合中
            if (count == 0){
                result.add(left);
            }

            // 如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，
            // 将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，
            // 所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
            if (right - left == p.length()) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)] ++;
                left ++;
            }
        }
            return result;
    }

    public static void main(String[] args) {
        String p = "abcdefg";
        int[] hash = new int[256];
        for (char i : p.toCharArray()) {
            hash[i]++;

        }

        System.out.println(hash);

    }
}
