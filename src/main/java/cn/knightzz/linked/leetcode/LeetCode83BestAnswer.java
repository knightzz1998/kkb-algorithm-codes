package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import static cn.knightzz.linked.util.ListNodeUtils.createLink;
import static cn.knightzz.linked.util.ListNodeUtils.getListNodeInfo;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @Author: 王天赐
 * @Date: 2022/06/12/17:44
 * @Description:
 */
@SuppressWarnings("all")
public class LeetCode83BestAnswer {


    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if(head == null || head.next == null) {
                return head;
            }

            // 双指针 =>
            // 1->1->1->2->2->3->4->
            // 指针a指向开头, 指针b向后遍历, 直到与a的值不同即可, 然后删除中间的

            // 一些特例 : 1->1->1->1->1->

            ListNode left = head;
            ListNode right = head;

            while(left != null && left.next != null){

                // right指针向后遍历
                do{
                    right = right.next;

                }while (right != null && left.val == right.val);

                left.next = right;
                left = right;
            }

            return head;
        }
    }

    public static void main(String[] args) {

        Solution solution = new LeetCode83BestAnswer().new Solution();
        //int[] nums = new int[]{1,1,2,3,3};
        int[] nums = new int[]{1,1,1,1,1};
        ListNode link = createLink(nums);
        ListNode listNode = solution.deleteDuplicates(link);
        getListNodeInfo(listNode);

    }
}
