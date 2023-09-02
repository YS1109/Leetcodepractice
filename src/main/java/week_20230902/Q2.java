package week_20230902;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。
 *
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 *
 * 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。
 *
 *
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 *
 * 输入：s1 = "abcdba", s2 = "cabdab"
 * 输出：true
 * 解释：我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbadba" 。
 * - 选择下标 i = 2 ，j = 4 ，得到字符串 s1 = "cbbdaa" 。
 * - 选择下标 i = 1 ，j = 5 ，得到字符串 s1 = "cabdab" = s2 。
 *
 * 输入：s1 = "abe", s2 = "bea"
 * 输出：false
 * 解释：无法让两个字符串相等。
 */
public class Q2 {
    public boolean checkStrings(String s1, String s2) {
        List<Character> s1OldCharList = new ArrayList<>();
        List<Character> s2OldCharList = new ArrayList<>();
        List<Character> s1NumCharList = new ArrayList<>();
        List<Character> s2NumCharList = new ArrayList<>();

        int num = 0;
        for (char s : s1.toCharArray()) {
            if (num % 2 == 0) {
                s1OldCharList.add(s);
            } else {
                s1NumCharList.add(s);
            }
            num++;
        }
        num = 0;
        for (char s : s2.toCharArray()) {
            if (num % 2 == 0) {
                s2OldCharList.add(s);
            } else {
                s2NumCharList.add(s);
            }
            num++;
        }
        Collections.sort(s1NumCharList);
        Collections.sort(s2NumCharList);
        Collections.sort(s1OldCharList);
        Collections.sort(s2OldCharList);

        StringBuilder newS1Builder = new StringBuilder();
        StringBuilder newS2Builder = new StringBuilder();

        num = 0;
        while(num < s1NumCharList.size() || num < s2NumCharList.size() || num < s1OldCharList.size() || num < s2OldCharList.size()) {
            if (num % 2 == 0) {
                if (num < s1OldCharList.size()) {
                    newS1Builder.append(s1OldCharList.get(num));
                }
                if (num < s2OldCharList.size()) {
                    newS2Builder.append(s2OldCharList.get(num));
                }
                if (num < s1NumCharList.size()) {
                    newS1Builder.append(s1NumCharList.get(num));
                }
                if (num < s2NumCharList.size()) {
                    newS2Builder.append(s2NumCharList.get(num));
                }
            } else {
                if (num < s1NumCharList.size()) {
                    newS1Builder.append(s1NumCharList.get(num));
                }
                if (num < s2NumCharList.size()) {
                    newS2Builder.append(s2NumCharList.get(num));
                }
                if (num < s1OldCharList.size()) {
                    newS1Builder.append(s1OldCharList.get(num));
                }
                if (num < s2OldCharList.size()) {
                    newS2Builder.append(s2OldCharList.get(num));
                }
            }
            num++;
        }
        return newS1Builder.toString().contentEquals(newS2Builder);
    }
}
