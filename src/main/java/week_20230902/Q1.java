package week_20230902;

/**
 * 给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
 *
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 *
 * 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 *
 * 输入：s1 = "abcd", s2 = "cdab"
 * 输出：true
 * 解释： 我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbad" 。
 * - 选择下标 i = 1 ，j = 3 ，得到字符串 s1 = "cdab" = s2 。
 *
 * 输入：s1 = "abcd", s2 = "dacb"
 * 输出：false
 * 解释：无法让两个字符串相等。
 */
public class Q1 {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s2Array = s2.toCharArray();
        if (s1.charAt(0) != s2.charAt(0)) {
            char tmp = s2Array[2];
            // 交换
            s2Array[2] = s2Array[0];
            s2Array[0] = tmp;
        }
        if (s1.charAt(1) != s2.charAt(1)) {
            char tmp = s2Array[3];
            s2Array[3] = s2Array[1];
            s2Array[1] = tmp;
            // 交换
        }
        s2 = new String(s2Array);
        return s1.equals(s2);
    }
}
