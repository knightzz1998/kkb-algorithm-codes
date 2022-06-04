package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;
import cn.knightzz.linked.util.ListNodeUtils;

/**
 * @author 王天赐
 * @title: LeetCode206Recursion
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/6/3 18:11
 */
@SuppressWarnings("all")
public class LeetCode206Recursion {

    class Solution {
        public ListNode reverseList(ListNode head) {

            if (head == null) {
                return head;
            }

            return reverse(head);
        }

        public ListNode reverse(ListNode head) {

            // 1 , 2 , 3, 4, 5, null

            // 递归边界
            if (head == null || head.next == null) {
                return head;
            }

            // 将当前节点后面所有的节点逆转
            ListNode reverseHead = reverse(head.next);
            ListNode tail = head.next;

            head.next = tail.next;
            tail.next = head;

            return reverseHead;
        }
    }

    public static void main(String[] args) {
        LeetCode206Recursion.Solution solution = new LeetCode206Recursion().new Solution();

        ListNode link = ListNodeUtils.createLink(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = solution.reverseList(link);

        ListNodeUtils.getListNodeInfo(listNode);
    }
}
