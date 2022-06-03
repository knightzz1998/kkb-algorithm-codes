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

        public ListNode reverse(ListNode node) {

            // 1 , 2 , 3, 4, 5, null

            // 递归边界
            if (node == null || node.next == null) {
                return node;
            }

            // 将当前节点后面所有的节点逆转
            ListNode pre = reverse(node.next);
            // 注意啊 这个 pre 是 逆序过来的头结点
            node.next.next = node;
            node.next = null;
            return pre;
        }
    }

    public static void main(String[] args) {
        LeetCode206Recursion.Solution solution = new LeetCode206Recursion().new Solution();

        ListNode link = ListNodeUtils.createLink(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = solution.reverseList(link);

        ListNodeUtils.getListNodeInfo(listNode);
    }
}
