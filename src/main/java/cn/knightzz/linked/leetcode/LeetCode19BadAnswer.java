package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import static cn.knightzz.linked.util.ListNodeUtils.*;


/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @Author: 王天赐
 * @Date: 2022/06/11/21:13
 * @Description:
 */
@SuppressWarnings("all")
public class LeetCode19BadAnswer {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // 删除节点记住, 要加虚拟节点
            // -1->1->2->3->4->5
            // 倒数第二个 = 正数第 5 个 = len - n + 1
            // 但是我们需要到倒数第 n + 1 个 => len - n

            ListNode dummy = new ListNode(-1, head);

            ListNode p = dummy;
            int len = 1;

            while(p.next != null) {
                p = p.next;
                len++;
            }

            int count = len - n;
            p = dummy;

            while (count != 1) {
                p = p.next;
                count--;
            }

            p.next = p.next.next;

            return dummy.next;
        }
    }

    public static void main(String[] args) {

        LeetCode19BadAnswer.Solution solution = new LeetCode19BadAnswer().new Solution();

        ListNode link = createLink(1, true);

        ListNode listNode = solution.removeNthFromEnd(link, 1);
        getListNodeInfo(listNode);
    }
}
