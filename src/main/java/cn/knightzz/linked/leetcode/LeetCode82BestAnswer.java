package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import static cn.knightzz.linked.util.ListNodeUtils.createLink;
import static cn.knightzz.linked.util.ListNodeUtils.getListNodeInfo;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @Author: 王天赐
 * @Date: 2022/06/12/18:11
 * @Description:
 */
@SuppressWarnings("all")
public class LeetCode82BestAnswer {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1000, head);
            ListNode left = dummy;
            ListNode right = dummy;

            int value = left.val;

            // -1->1->2->3->3->
            // -1->1->1->1->2->3->

            while(right != null && right.next != null) {

                right = right.next;
                if (right.val != value) {

                    value = right.val;

                    if (right.next != null && right.next.val != value) {
                        // right.next != null right指针指到最后一位
                        left = right;
                    }
                }else {
                    // 删除节点
                    left.next = right.next;

                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {

        Solution solution = new LeetCode82BestAnswer().new Solution();
        int[] nums = new int[]{1,2,3,3,4,4,5};
        //int[] nums = new int[]{1,1,1,1,1};
        ListNode link = createLink(nums);
        ListNode listNode = solution.deleteDuplicates(link);
        getListNodeInfo(listNode);

    }
}
