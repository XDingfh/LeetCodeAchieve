package org.dingfenghao.leetcode;

/**
 * @author dingfenghao
 */
public class leetCode167 {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    /**
     * 解题思路
     * 二分查找法。因为是有序的数组，所以设置两个指针，分别指向数组头部和数组尾部。也就是
     * 最大值和最小值，两个值相加，如果大于target，说明加的最大值太大了，指向数组尾部的
     * 指针向左移动一位。反正，如果小于target，说明加的最小值太小了，数组头部的指针向右移动
     * 一位。直到两个数的相加等于target
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 , right = numbers.length-1;
        int[] ans = new int[2];
        while (left <right){
            int  sum = numbers[left] +numbers [right];
            if(sum <target){
                left ++;
            }else if(sum >target){
                right --;
            }else if(sum == target){
                ans =  new int []{left+1,right+1};
                break;
            }
        }
        return  ans;
    }
}
