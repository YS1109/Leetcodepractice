package question1_10;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 不将整数转为字符串来解决这个问题
 */

/**
 * 思路：不使用字符串，就是将数字反转，然后判断是否相等便能解题
 */
public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    public int reverse(int x) {
        boolean flag = (x >= 0);
        if (x == -2147483648) {
            return 0;
        }
        if (!flag) {
            x = x * -1;
        }
        int result = 0;
        int judgeNum = 2147483647;
        int baseNum = 1000000000;
        boolean needJudge = x > 1000000000;
        if (!needJudge) {
            while (x > 0) {
                result = result * 10;
                result += x % 10;
                x = x / 10;
            }
            return flag ? result : (result * -1);
        }
        while (x >= 10) {
            if (needJudge) {
                if (x % 10 > judgeNum / baseNum) {
                    return 0;
                } else if (x % 10 < judgeNum / baseNum) {
                    needJudge = false;
                }
            }
            result += (x % 10) * baseNum;
            judgeNum = judgeNum - ((judgeNum / baseNum) * baseNum);
            baseNum /= 10;
            x = x / 10;
        }
        if (needJudge) {
            if (!flag) {
                judgeNum++;
            }
            if (x > judgeNum) {
                return 0;
            }
        }
        result += x;
        return flag ? result : (result * -1);
    }
}
