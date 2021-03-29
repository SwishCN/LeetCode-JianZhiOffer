/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 思路：
 * 从头到尾遍历节点入栈，再依次出栈。
 * 尽量避免递归，可能会造成栈溢出。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int size = stack.size();
        int[] re = new int[size];

        for (int i = 0; i < size; i++) {
            re[i] =stack.pop().val;
        }

        return re;
    }
}