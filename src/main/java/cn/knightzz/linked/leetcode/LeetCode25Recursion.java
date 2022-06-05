package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;
import cn.knightzz.linked.util.ListNodeUtils;

/**
 * @author 王天赐
 * @title: LeetCode25BestAnswer
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 5/6/2022 下午8:22
 */
@SuppressWarnings("all")
public class LeetCode25Recursion {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            int count = 1;
            ListNode p = head;

            while(p.next != null) {
                p = p.next;
                count++;
            }

            int nums = count / k;

            int left = 1;
            int right = k;
            ListNode node = head;
            for (int i = 0; i < nums; i++) {
                node = reverseBetween(node, left, right);
                left += k;
                right+= k;
            }
            return node;
        }

        public ListNode reverseBetween(ListNode node, int  left, int right) {

            if (node == null || node.next == null || left >= right) {
                return node;
            }

            int count = left;
            // 创建虚拟头节点 [关键]
            ListNode pre = new ListNode(-1, node);
            ListNode p = pre;

            while(count != 1) {
                p = p.next;
                count--;
            }

            ListNode head = reverseN(p.next,right - left + 1);
            p.next = head;

            return pre.next;
        }

        public ListNode reverseN(ListNode head, int n){

            // 边界条件
            if (n == 1) {
                return head;
            }

            // 翻后转链表的头部
            ListNode tail = reverseN(head.next, n - 1);
            // 翻转链表的头部 , 注意 tail.next = null / 第 n + 1 个节点
            ListNode p = head.next;

            // 原因是 如果顺序反了, tail指向的目标会丢失
            head.next = p.next;
            p.next = head;
            return tail;
        }

    }

    public static void main(String[] args) {

        Solution solution = new LeetCode25Recursion().new Solution();

        ListNode link = ListNodeUtils.createLink(10, true);
        // ListNodeUtils.getListNodeInfo(solution.reverseN(link, 5));
        // ListNodeUtils.getListNodeInfo(solution.reverseBetween(link, 3, 5));
        ListNodeUtils.getListNodeInfo(link);
        ListNode listNode = solution.reverseKGroup(link, 2);
        ListNodeUtils.getListNodeInfo(listNode);


    }
}
