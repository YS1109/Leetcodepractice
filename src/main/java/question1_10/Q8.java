package question1_10;

/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q8 {
    public int myAtoi(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }
            int result = 0;
            boolean flag;
            char currentChar = s.charAt(0);
            if (currentChar == '-') {
                flag = false;
            }
            else if (currentChar == '+') {
                flag = true;
            }
            else if (currentChar - '0' >= 0 && currentChar - '0' <= 9) {
                flag = true;
                result += currentChar - '0';
            }
            else {
                return 0;
            }
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                currentChar = chars[i];
                if (currentChar - '0' >= 0 && currentChar - '0' <= 9) {
                    if (result > Integer.MAX_VALUE / 10) {
                        return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    result *= 10;
                    result += currentChar - '0';
                    if (result < 0) {
                        return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                }
                else {
                    break;
                }
            }
            return flag ? result : result * -1;
        }
}
