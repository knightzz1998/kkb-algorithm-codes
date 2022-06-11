package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import static cn.knightzz.linked.util.ListNodeUtils.createLink;
import static cn.knightzz.linked.util.ListNodeUtils.getListNodeInfo;


/**
 * 19. 删除链表的倒数第 N 个结点(最优解法)
 *
 * @Author: 王天赐
 * @Date: 2022/06/11/21:13
 * @Description:
 */
@SuppressWarnings("all")
public class LeetCode19BestAnswer {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // 双指针
            // a->b 两个指针相距离 n
            ListNode dummy = new ListNode(-1, head);
            ListNode left = dummy;
            ListNode right = dummy;

            // 右指针先走 n 步, 保证左右指针距离等于n

            for (int i = 0; i < n; i++) {
                right = right.next;
            }

            // -1->1->2->3->4->5->6->7->

            // -1->1->
            while (right.next != null) {
                right = right.next;
                left = left.next;
            }

            // 直到 右指针到末尾, 左指针到被删除的指针的前一个指针
            left.next = left.next.next;

            return dummy.next;
        }
    }

    public static void main(String[] args) {

        LeetCode19BestAnswer.Solution solution = new LeetCode19BestAnswer().new Solution();

        ListNode link = createLink(1, true);

        ListNode listNode = solution.removeNthFromEnd(link, 1);
        getListNodeInfo(listNode);
    }
}
