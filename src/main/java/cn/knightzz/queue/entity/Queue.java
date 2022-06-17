package cn.knightzz.queue.entity;

/**
 * @author 王天赐
 * @title: Queue
 * @projectName kkb-algorithm-codes
 * @description: 使用数组创建队列
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-06-16 20:11
 */
public class Queue {

    private int tail, head;
    private int[] cache;

    public Queue(int len) {

        if (len < 1) {
            throw new RuntimeException("错误 ! , 队列长度小于1!");
        }

        this.head = 0;
        this.tail = 0;
        this.cache = new int[len];
    }

    /**
     * 入队
     * @param x 需要放入队列的元素
     */
    public void push(int x) {

        if (full()) {
            throw new RuntimeException("队列已满!");
        }

        this.cache[tail] = x;

        // 这里需要注意的是, tail指向的是实际尾部的下一个位置
        tail++;
    }

    /**
     * 队列元素出队
     * @return
     */
    public int pop(){

        if (empty()) {
            throw new RuntimeException("错误 !, 队列元素为空 ");
        }

        int value = this.cache[head];
        head++;
        return value;
    }

    /**
     * 判断队列是否已满
     * @return 如果已满, 返回true, 反之返回 false
     */
    public boolean full() {
        return tail == cache.length;
    }

    /**
     * 判断队列是否为空
     * @return 如果为空, 返回true, 反之返回 false
     */
    public boolean empty(){
        return tail == head;
    }

    /**
     * 查看队首元素
     * @return
     */
    public int front(){
        return this.cache[head];
    }

    /**
     * 输出队列中所有元素
     */
    public void output() {

        for (int i = tail - 1; i >= head; i--) {
            System.out.print("| ");
            System.out.print(cache[i]);
            System.out.println(" |");
        }
    }

    public static void main(String[] args) {

        Queue queue = new Queue(10);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        queue.output();
    }
}
