package question11_20;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int index = 0;
        while (true) {
            if (index + 1 > strs[0].length()) {
                break;
            }
            char currentChar = strs[0].charAt(index);
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (index + 1 > strs[i].length() || strs[i].charAt(index) != currentChar) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            result = result + currentChar;
            index = index + 1;
        }
        return result;
    }
}
