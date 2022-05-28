package cn.knightzz.linked.util;

import cn.knightzz.linked.entity.ListNode;

/**
 * @author 王天赐
 * @title: LinkNodeUtils
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/28 15:17
 */
public class ListNodeUtils {

    /**
     * 创建链表
     * @param nums
     * @return 返回链表的头部
     */
    public static ListNode createLink(int[] nums){

        ListNode head = new ListNode(nums[0]);
        ListNode p = head;

        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
}
