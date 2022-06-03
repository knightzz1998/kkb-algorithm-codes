package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

/**
 * @author 王天赐
 * @title: LeetCode206BestAnswer
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/6/3 17:23
 */
@SuppressWarnings("all")
public class LeetCode206BestAnswer {

    class Solution {
        public ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;
            ListNode next = head.next;

            while (cur != null) {

                // cur->pre
                // next->cur

                cur.next = pre;

                // 向后移动
                pre = cur;
                cur = next;

                // 细节 : 考虑边界情况
                // 当 next指向null时, 此时 cur指向最后一个节点, 但是注意 : 此时cur指向的节点链表还没有反转!!!
                // 所以需要判断下, 不让next继续向后, 因为会空指针, 另外当cur==null时, 跳出循环, 此时应该返回的是 pre, 因为pre指向的才是头结点

                if (next != null) {
                    next = next.next;
                }
            }

            return pre;
        }
    }

    public static void main(String[] args) {

        Solution solution = new LeetCode206BestAnswer().new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        solution.reverseList(head);

    }
}
