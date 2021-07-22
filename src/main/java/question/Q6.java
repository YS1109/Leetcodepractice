package question;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q6 {
    /**
     * 思路：
     * 读题读了半天，原来是把句子变成竖着的Z形状，然后再横着读
     * 笨方法就是写一个数组，暴力竖着实现完之后横着读
     * 1   7
     * 2  68
     * 3 5 9
     * 4   10
     *
     * 找规律：
     * 总行数为row，当前行数为crow，则将2row - 2为一组数据，分为n组 (n从0开始)
     * 每组数据第一行的下标为 n(2row - 2)
     * 大于第一行小于最后一行的下标为 n(2row -2) + crow，n(2row - 2) + row + (row - 1 - crow)
     * 最后一行的下标为 n(2row -2) + row - 1
     * 需要考虑边界条件，最后一组计算得到下标是否存在
     */
    public String convert(String s, int numRows) {
        //计算数据的组数
        if (numRows == 1) {
            return s;
        }
        int n = s.length() / (2 * numRows - 2);
        StringBuffer result = new StringBuffer();
        //第一行数的数据
        for (int i = 0; i <= n ; i++) {
            int index = i * (2 * numRows - 2);
            if (index < s.length()) {
                result.append(s.charAt(index));
            }
        }
        //大于第一行小于最后一行的数据
        for (int crow = 1; crow < numRows - 1; crow++) {
            for (int i = 0; i <= n; i++) {
                int index1 = i * (2 * numRows - 2) + crow;
                int index2 = i * (2 * numRows - 2) + (numRows - 1) + (numRows - 1 - crow);
                if (index1 < s.length()) {
                    result.append(s.charAt(index1));
                }
                if (index2 < s.length()) {
                    result.append(s.charAt(index2));
                }
            }
        }
        //最后一行的数据
        for (int i = 0; i <= n ; i++) {
            int index = i * (2 * numRows - 2) + (numRows - 1);
            if (index < s.length()) {
                result.append(s.charAt(index));
            }
        }
        return result.toString();
    }
}
