package cn.knightzz.linked.entity;

/**
 * @author 王天赐
 * @title: ListNode
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/25 21:06
 */
@SuppressWarnings("all")
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
