package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;
import cn.knightzz.linked.util.ListNodeUtils;

/**
 * @author 王天赐
 * @title: LeetCode114
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/25 20:41
 */
@SuppressWarnings("all")
public class LeetCode141TwoPoint {

    class Solution {
        public boolean hasCycle(ListNode head) {

            if (head == null) {
                return false;
            }

            // 定义两个指针
            ListNode fastPoint = head;
            ListNode slowPoint = head;

            // 当快指针指向空, 或者快指针的next指向空的时候, 说明没有环
            while (fastPoint != null && fastPoint.next != null) {
                fastPoint = fastPoint.next.next;
                slowPoint = slowPoint.next;

                // 快慢指针相遇说明有环
                if (fastPoint == slowPoint) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,4,2,1};
        ListNode node = ListNodeUtils.createLink(nums);
        Solution solution = new LeetCode141TwoPoint().new Solution();

        boolean hasCycle = solution.hasCycle(node);

        System.out.println(hasCycle ? "有环":"无环");
    }
}
