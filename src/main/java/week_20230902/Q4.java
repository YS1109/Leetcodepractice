package week_20230902;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个字符串 s 和一个整数 k 。
 *
 * k 子序列指的是 s 的一个长度为 k 的 子序列 ，且所有字符都是 唯一 的，也就是说每个字符在子序列里只出现过一次。
 *
 * 定义 f(c) 为字符 c 在 s 中出现的次数。
 *
 * k 子序列的 美丽值 定义为这个子序列中每一个字符 c 的 f(c) 之 和 。
 *
 * 比方说，s = "abbbdd" 和 k = 2 ，我们有：
 *
 * f('a') = 1, f('b') = 3, f('d') = 2
 * s 的部分 k 子序列为：
 * "abbbdd" -> "ab" ，美丽值为 f('a') + f('b') = 4
 * "abbbdd" -> "ad" ，美丽值为 f('a') + f('d') = 3
 * "abbbdd" -> "bd" ，美丽值为 f('b') + f('d') = 5
 * 请你返回一个整数，表示所有 k 子序列 里面 美丽值 是 最大值 的子序列数目。由于答案可能很大，将结果对 10 ^ 9 + 7 取余后返回。
 *
 * 一个字符串的子序列指的是从原字符串里面删除一些字符（也可能一个字符也不删除），不改变剩下字符顺序连接得到的新字符串。
 *
 * 注意：
 *
 * f(c) 指的是字符 c 在字符串 s 的出现次数，不是在 k 子序列里的出现次数。
 * 两个 k 子序列如果有任何一个字符在原字符串中的下标不同，则它们是两个不同的子序列。所以两个不同的 k 子序列可能产生相同的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcca", k = 2
 * 输出：4
 * 解释：s 中我们有 f('a') = 1 ，f('b') = 1 和 f('c') = 2 。
 * s 的 k 子序列为：
 * bcca ，美丽值为 f('b') + f('c') = 3
 * bcca ，美丽值为 f('b') + f('c') = 3
 * bcca ，美丽值为 f('b') + f('a') = 2
 * bcca ，美丽值为 f('c') + f('a') = 3
 * bcca ，美丽值为 f('c') + f('a') = 3
 * 总共有 4 个 k 子序列美丽值为最大值 3 。
 * 所以答案为 4 。
 * 示例 2：
 *
 * 输入：s = "abbcd", k = 4
 * 输出：2
 * 解释：s 中我们有 f('a') = 1 ，f('b') = 2 ，f('c') = 1 和 f('d') = 1 。
 * s 的 k 子序列为：
 * abbcd ，美丽值为 f('a') + f('b') + f('c') + f('d') = 5
 * abbcd ，美丽值为 f('a') + f('b') + f('c') + f('d') = 5
 * 总共有 2 个 k 子序列美丽值为最大值 5 。
 * 所以答案为 2 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 10 ^ 5
 * 1 <= k <= s.length
 * s 只包含小写英文字母。
 */
public class Q4 {
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        // 计算s中各个字符的"美丽值"
        long count[] = new long[26], prod = 1;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        for (long i : count) {
            map.put(-i, map.getOrDefault(-i, 0) + 1);
        }
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            for (int i = 0; i < Math.min(k, entry.getValue()); i++) {
                prod = (prod * -entry.getKey()) % 1000000007;
            }
            for (int i = 0; k < entry.getValue() && i < k; i++) {
                prod = prod * (entry.getValue() - i) % 1000000007
                        * BigInteger.valueOf(i + 1).modInverse(BigInteger.valueOf(1000000007)).intValue() % 1000000007;
            }
            k -= Math.min(k, entry.getValue());
        }
        return (int) prod;
    }
}
