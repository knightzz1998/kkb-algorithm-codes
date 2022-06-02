package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;


/**
 * @author 王天赐
 * @title: LeetCode142BestAnswer
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/30 21:50
 */
@SuppressWarnings("all")
public class LeetCode142BestAnswer {

    class Solution {
        public ListNode detectCycle(ListNode head) {

            if (head == null || head.next == null) {
                return null;
            }

            // p 每次走一步
            ListNode p = head;
            // q 每次走两步
            ListNode q = head;
            // 先判断链表是否有环
            while(q != null && q.next != null) {
                p = p.next;
                q = q.next.next;

                if (p == q) {
                    break;
                }
            }

            // 无环的情况
            if (q == null || q.next == null) {
                return null;
            }

            // p 从起点触发, q从相遇点触发, 二者每次都走一步, 因为二者到达环的起始点距离相等
            p = head;
            while(p != q) {
                p = p.next;
                q = q.next;
            }

            return p;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

    }
}
