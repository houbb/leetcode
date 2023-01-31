package com.github.houbb.leetcode.F200T300;

public class T202_HappyNumberV2 {

    public static void main(String[] args) {
        T202_HappyNumberV2 happyNumber = new T202_HappyNumberV2();

//        System.out.println(happyNumber.isHappy(19));
//        System.out.println(happyNumber.isHappy(2));
        System.out.println(happyNumber.isHappy(7));
    }

    /**
     * 超时
     *
     * https://leetcode.com/problems/happy-number/solutions/56917/my-solution-in-c-o-1-space-and-no-magic-math-property-involved/
     *
     * 本质上这一题应该和循环链表类似？
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;

        // 快慢指针
        do {
            slow = calc(slow);
            fast = calc(fast);
            fast = calc(fast);
        } while(slow != fast);

        return slow == 1;
    }

    private int calc(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

}
