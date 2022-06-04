package cn.knightzz.linked.util;

import cn.hutool.core.util.RandomUtil;
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

        return getListNode(nums);
    }

    public static ListNode createLink(int n, Boolean isSorted){

        int[] nums = RandomUtil.randomInts(n);
        if (isSorted) {
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
        }
        return getListNode(nums);
    }

    private static ListNode getListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;

        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }

    public static void getListNodeInfo(ListNode head ){
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
