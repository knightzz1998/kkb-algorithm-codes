package cn.knightzz.linked.leetcode;

/**
 * @author 王天赐
 * @title: LeetCode202BaseLine
 * @projectName kkb-algorithm-codes
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/6/2 21:13
 */
@SuppressWarnings("all")
public class LeetCode202BestAnswer {

    class Solution {
        public boolean isHappy(int n) {

            // 使用链表的思维 : n = 19
            // 1^2 + 9^2 = 82
            // 82^2 + 22^2 = 68
            // 6^2 + 8^2 = 100
            // 1^2 + 0^2 + 0^2 = 1
            // 19->82->68->100->1 => 无环
            // 假如出现重复的 比如 19->82->68->100->82 说明就有环
            int fast = n;
            int slow = n;

            while(fast != 1) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));

                // 打印
                // 注意: 如果slow==1 , 那么 fast 肯定等于1, 需要排除这种情况
                if (fast == slow && fast != 1) {
                    // 有环 => 非快乐数
                    return false;
                }
            }

            // 无环 => 快乐数
            return true;
        }

        private int getNext(int x) {
            int res = 0;
            while(x != 0) {
                // 和 10 求余是取最后一位
                res += (x % 10) * (x % 10);
                x /= 10;
            }
            return res;
        }
    }

    public static void main(String[] args) {

        Solution solution = new LeetCode202BestAnswer().new Solution();
        System.out.println("solution.isHappy() = " + solution.isHappy(10));

    }
}
