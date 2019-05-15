package org.dingfenghao.leetcode;

public class LeetCode441 {


    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     *
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     *
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * 示例 1:
     *
     * n = 5
     *
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤
     *
     * 因为第三行不完整，所以返回2.
     * 示例 2:
     *
     * n = 8
     *
     * 硬币可排列成以下几行:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     *
     * 因为第四行不完整，所以返回3.
     */

    /**
     * 解题思路：使用二分查找法。
     * 公式 1+2+3+...+n = ((1+n)/2)*n,也就是首尾的均值乘以n等于和
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        if(n == 1){
            return 1;
        }
        long nlong = (long) n;

        long start = 0, end = nlong;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;

            if(mid*(mid+1) <= 2*nlong){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return (int)(start);
    }

    /**
     * O(1)时间复杂度解放 利用数学方法
     * X*(1+X)/2 <=n
     * <p>
     * X+X2 <=  2n
     * <p>
     * 这里就要用配方法
     * <p>
     * 4X+ 4X2 <=  4*2*n
     * <p>
     * (2X+1)2 - 1 <= 8n
     *
     * @param C
     * @return
     */
    public int arrangeCoins2(int C) {
        return (int) (1.0 / 2.0 * (Math.sqrt(8.0 * C + 1.0) - 1.0));
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(6) );
    }
}
