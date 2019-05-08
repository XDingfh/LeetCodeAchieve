package org.dingfenghao.leetcode;

/**
 * @author dingfenghao
 */
public class leetCode434 {

    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     *
     * 示例:
     *
     * 输入: "Hello, my name is John"
     * 输出: 5
     */

    /**
     * @param s
     * @return
     */
    public int countSegments(String s) {
        boolean isChars = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                isChars = false;
            }else{
                if(!isChars){
                    count++;
                }
                isChars = true;
            }
        }
        return count;
    }
}
