/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 思路：
 * StringBuilder是一个可变对象，可以预分配缓冲区，往StringBuilder中新增字符时，不会创建新的临时对象。
 */
class Solution {
    public String replaceSpace(String s) {
        StringBuilder newS = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c != ' ') {
                newS.append(c);
            } else {
                newS.append("%20");
            }

        }

        return newS.toString();
    }
}