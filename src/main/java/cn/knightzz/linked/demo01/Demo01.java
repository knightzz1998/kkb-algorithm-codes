package cn.knightzz.linked.demo01;

/**
 * @author 王天赐
 * @title: LinkDemo01
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/5/23 17:26
 */
public class Demo01 {

    public static void main(String[] args) {

        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node p = head;

        // 遍历链表
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

}
