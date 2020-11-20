package question;

public class Q5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 1.根据示例一得出返回出现的第一个最长的回文串
     * 2.回文串的正中心一定与左边相同或者该位置两端的数相同，之后依次向前或向后比较计算长度。
     * 3.主要边界情况： aaa 和 aaaa 这种类型 
     */
    public String longestPalindrome(String s) {
        return forceAnwser(s);
    }

    private String forceAnwser(String s) {
        char[] str = s.toCharArray();
        int  left = 0, right = 0, max_left = 0, max_right = 0, length = 0, max_length = 0;
        for (int now = 1; now < s.length(); now++) {
            if ((now + 1) < str.length && str[now - 1] == str[now + 1]) {
                length = 3;
                left = now - 1 - 1;
                right = now + 2;
                while(left >= 0 && right < str.length) {
                    if (str[left] == str[right]) {
                        length += 2;
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                if(length > max_length) {
                    max_left = left + 1;
                    max_right = right - 1;
                    max_length = length;
                }
            }
            if (str[now] == str[now - 1]) {
                length = 2;
                left = now - 1 - 1;
                right = now + 1;
                while(left >= 0 && right < str.length) {
                    if (str[left] == str[right]) {
                        length += 2;
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                if(length > max_length) {
                    max_left = left + 1;
                    max_right = right - 1;
                    max_length = length;
                }
            }
        }
        String result = "";
        for (int i = max_left; i <= max_right; i++) {
            result += str[i];
        }
        return result;
    }
}
