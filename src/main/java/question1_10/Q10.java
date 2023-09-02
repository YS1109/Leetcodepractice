package question1_10;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路：
 * 规则串第一个一定不是*
 *
 */
public class Q10 {
    public boolean isMatch(String s, String p) {
        return dp(s, p);
    }

    /**
     * 回溯递归方法
     * 实现逻辑：
     * 每次都比较 s 和 p 的头部元素，同时判断 p 的后一位元素是否有 *
     * 分为以下三种情况：
     * 1.不存在 * :直接截取掉两个字符串的头部元素
     * 2.存在 * ,并且头部元素相等, 截取掉 s 的头部元素
     * 3.存在 * ,并且头部元素不相等, 截取掉 p 的前两位元素
     * 与此同时注意判断边界情况就ok了
     * @param s
     * @param p
     * @return
     */
    private boolean recursiveBacktracking(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return recursiveBacktracking(s, p.substring(2)) || (firstMatch && recursiveBacktracking(s.substring(1), p));
        } else {
            return firstMatch && recursiveBacktracking(s.substring(1), p.substring(1));
        }
    }

    /**
     * dp解法
     * @param s
     * @param p
     * @return
     */
    private boolean dp(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // 包含通配符，还是上面的两种情况，一种是直接截掉 p 的两个字符进行判断，另一种是 将 s 的当前字符截掉进行判断
                    dp[i][j] = dp[i][j - 2] || (isValueMatch(s, p, i - 1, j - 2) && dp[i - 1][j]);
                } else {
                    // 不包含通配符，就比较当前的值是否相等以及前面的字串是否匹配
                    dp[i][j] = isValueMatch(s, p, i - 1, j -1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean isValueMatch(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
