package cn.knightzz.linked.leetcode;

import cn.knightzz.linked.entity.ListNode;

import java.util.HashMap;

/**
 * @author 王天赐
 * @title: LeetCode142
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/28 15:32
 */
@SuppressWarnings("all")
public class LeetCode142HashTable {

    class Solution {
        public ListNode detectCycle(ListNode head) {

            if (head == null || head.next == null) {
                return null;
            }

            // 思路很简单 : 使用 HashMap 记录 每个节点的Hash值, 然后遍历, 判断当前节点的下一个节点是否已经记录在哈希表里
            // 如果已经记录 => 下一个就是环的头结点
            // 如果没有记录 => 继续
            // 当前节点的next为 null 跳出循环 => 无环

            HashMap<Integer, ListNode> hashMap = new HashMap<>();

            ListNode p = head;

            while(p !=null && p.next != null) {

                int hashCode = p.next.hashCode();

                if (hashMap.get(hashCode) != null) {
                    // 如果当前节点的下一个节点已经在哈希表里 => 这个是环的头结点
                    return p.next;
                }

                hashMap.put(p.hashCode(), p);

                p = p.next;
            }

            return null;
        }
    }
}
