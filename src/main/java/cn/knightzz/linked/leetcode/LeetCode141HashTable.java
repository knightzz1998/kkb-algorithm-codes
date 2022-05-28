package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import java.util.HashMap;

/**
 * @author 王天赐
 * @title: LeetCode141HashTable
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/25 21:07
 */
@SuppressWarnings("all")
public class LeetCode141HashTable {

    class Solution {
        public boolean hasCycle(ListNode head) {

            if (head == null) {
                return false;
            }

            HashMap<Integer, Integer> hashtable = new HashMap<>();
            ListNode p = head;

            // 使用哈希表的方式, 将数据放入进去
            while (p != null && p.next != null) {

                // 使用哈希值来标记
                int hashCode = p.hashCode();

                // Hash 表的方式, 要保证key不同, 如果key相同就没法用哈希表
                // 这种方式假设链表的值都不相同
                if (hashtable.get(hashCode) != null) {
                    return true;
                }

                hashtable.put(hashCode, p.val);
                p = p.next;

            }

            return false;
        }
    }
}
