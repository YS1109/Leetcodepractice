package question21_30;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class Q22 {
    public List<String> generateParenthesis(int n) {
        Queue<String> resultQueue = new ArrayDeque<>();
        resultQueue.add("(");
        for (int i = 1; i < n * 2; i++) {
            while (resultQueue.element().length() == i) {
                String currentString = resultQueue.poll();
                int leftNum = 0;
                int rightNum = 0;
                for (int j = 0; j < i; j++) {
                    if (currentString.charAt(j) == '(') {
                        leftNum++;
                    }
                    else {
                        rightNum++;
                    }
                }
                if (leftNum < n) {
                    resultQueue.add(currentString + "(");
                }
                if (rightNum < n && rightNum < leftNum) {
                    resultQueue.add(currentString + ")");
                }
            }
        }
        return new ArrayList<>(resultQueue);
    }

}
