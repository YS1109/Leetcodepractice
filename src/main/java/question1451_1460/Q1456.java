package question1451_1460;

// https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class Q1456 {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int start = 0;
        int end = k - 1;
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (checkVowels(s.charAt(i))) {
                currentVowels++;
                maxVowels = Math.max(maxVowels, currentVowels);
            }
        }
        while (end < s.length() - 1) {
            if (checkVowels(s.charAt(start))) {
                currentVowels--;
            }
            start++;
            end++;
            if (checkVowels(s.charAt(end))) {
                currentVowels++;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }

    public boolean checkVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
