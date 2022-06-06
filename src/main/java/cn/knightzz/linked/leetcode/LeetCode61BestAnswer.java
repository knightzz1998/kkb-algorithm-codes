package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;
import cn.knightzz.linked.util.ListNodeUtils;

/**
 * @author 王天赐
 * @title: LeetCode61BestAnswer
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 6/6/2022 下午9:08
 */
@SuppressWarnings("all")
public class LeetCode61BestAnswer {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null || head.next == null) {
                return head;
            }

            int length = 1;

            ListNode tail = head;
            while(tail != null && tail.next != null) {
                tail = tail.next;
                length++;
            }

            // 注意 假设 length = 4, 则 k = 1 和 5 没有区别
            // 但是要注意的是
            int count = (length - k % length);

            if (count == 0) {
                return head;
            }

            // 注意断开的地方, 旋转是从尾结点开始转的, 注意 : 我们如果从头结点开始移动, 就要移动 3 步, 而不是 1 步 !


            tail.next = head;
            ListNode dummy = new ListNode(-1, head);
            ListNode p = dummy;
            while (count != 0) {
                p = p.next;
                count--;
            }
            // 虚拟头结点的作用 : 如果指针正好指向最初的头结点, 就没办法断开 , 下面部分的代码就会出现问题
            // 先获取新的头结点
            ListNode newHead = p.next;
            p.next = null;

            return newHead;
        }
    }

    public static void main(String[] args) {

        Solution solution = new LeetCode61BestAnswer().new Solution();

        ListNode link = ListNodeUtils.createLink(3, true);
        ListNodeUtils.getListNodeInfo(link);

        ListNode listNode = solution.rotateRight(link, 4);

        ListNodeUtils.getListNodeInfo(listNode);
    }

}
