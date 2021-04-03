/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 思路：
 * 寻找旋转数组的最小元素即为寻找 右排序数组 的首个元素nums[x]，称x为旋转点。
 * 排序数组的查找问题首先考虑使用 二分法 解决，其可将 遍历法 的 线性级别 时间复杂度降低至 对数级别。
 * 一、初始化：声明i,j双指针分别指向nums数组左右两端
 * 二、循环二分：设m=(i+j)/2为每次二分的中点（恒有i<=m<j）
 *     可分为以下三种情况：
 *     1.当nums[m]>nums[j]时：m一定在左排序数组中，即旋转点x一定在[m+1,j]闭区间内，因此执行i=m+1；
 *     2.当nums[m]<nums[j]时：m一定在右排序数组中，即旋转点x一定在[i,m]闭区间内，因此执行j=m；
 *     3.当nums[m]==nums[j]时：无法判断m在哪个排序数组中，即无法判断旋转点x在[i,m]还是[m+1,j]区间中。
 *       解决方案：执行j=j-1缩小判断范围
 * 三、返回值：当i==j时跳出二分循环，并返回旋转点的值nums[i]即可
 * 出处：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
 */
class Solution {

    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        int m;

        while (i < j) {
            m = (i + j) / 2;

            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }

        }

        return numbers[i];
    }

}