package question1_10;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31 − 1] ，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 解题思路：
 * 2的31次方等于2147483648
 * 先取数字的符号位，反转是不会改变符号的
 * 再对数字进行反转
 * 需要判断的是反转后的数字加上符号位是否超过32位
 * 这种情况只会出现在绝对值大于2^10的场景
 */
public class Q7 {
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
