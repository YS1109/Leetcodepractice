package question11_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Q17 {
    private Map<String, String> dict = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> preResult;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            preResult = result;
            result = new ArrayList<>();
            String letters = dict.get(String.valueOf(digits.charAt(i)));
            if (preResult.size() == 0) {
                for (int j = 0; j < letters.length(); j++) {
                    result.add(String.valueOf(letters.charAt(j)));
                }
            } else {
                for (String str : preResult) {
                    for (int j = 0; j < letters.length(); j++) {
                        result.add(str + letters.charAt(j));
                    }
                }
            }
        }
        return result;
    }
}
