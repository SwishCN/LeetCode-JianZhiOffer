/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100
 *
 * 思路：
 * 把n级台阶的跳法数量看成n的函数，记为f(n)。
 * 当n>2时，当青蛙跳到n-1级上，有f(n-1)种跳法，最后一次跳1级到n级。
 *         当青蛙跳到n-2级上，有f(n-2)种跳法，最后一次跳2级到n级（不能只条一级，已包含在f(n-1)中）。
 * 即使前n-2级跳法可能存在相同，但结合不同的最后一跳，产生不同的跳法
 * 即推出当n>2时，f(n)=f(n-1)+f(n-2)
 */
class Solution {

    public int numWays(int n) {

        if (n <= 1) {
            return 1;
        }

        int a = 1;
        int b = 2;
        int sum;

        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return  a;

    }

}