package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;
import cn.knightzz.linked.util.ListNodeUtils;

/**
 * @author 王天赐
 * @title: LeetCode92Recursion
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/6/4 12:21
 */
@SuppressWarnings("all")
public class LeetCode92Recursion {

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            if (head == null || head.next == null || left >= right) {
                return head;
            }

            // 反转指定区域的链表
            // 先到 left , 把 left 位置的 节点当做 head

            // 虚拟头结点
            ListNode pre = new ListNode(-1);
            pre.next = head;

            ListNode p = pre;
            int count = left;
            // 指针指向翻转头结点的前一个节点
            while (count != 1) {
                p = p.next;
                count--;
            }
            // 翻转前 n 个
            p.next = reverseN(p.next, (right - left + 1));

            // 因为有虚拟头结点的存在, 所以不会出现有环的情况
            // 模拟 : 1->2->
            // reverseN => 2->1->
            // 没有虚拟头结点
            // p = head = 1 : p 是翻转节点的前一个节点
            // => 1 -> 2 -> 1
            // 有虚拟头结点
            // p = 虚拟头结点 = -1
            // => p -> 1 -> 2

            return pre.next;
        }

        public ListNode reverseN(ListNode head, int n) {

            // 边界
            if (n == 1) {
                return head;
            }

            // 1 -> 2 -> 3 -> 4 ->                        5 ->
            ListNode reverseHead = reverseN(head.next, n - 1);
            ListNode tail = head.next;

            // reverseHead 是反转的头, tail 是尾部
            head.next = tail.next;
            tail.next = head;

            return reverseHead;
        }
    }

    public static void main(String[] args) {
        LeetCode92Recursion.Solution solution = new LeetCode92Recursion().new Solution();

        ListNode link = ListNodeUtils.createLink(2, true);

        ListNodeUtils.getListNodeInfo(link);

        ListNode listNode = solution.reverseN(link, 2);
        ListNodeUtils.getListNodeInfo(listNode);

        link = ListNodeUtils.createLink(2, true);
        ListNode node = solution.reverseBetween(link, 1, 2);
        ListNodeUtils.getListNodeInfo(node);
    }
}
