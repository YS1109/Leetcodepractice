package question1651_1660;

public class Q1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        int r = k > 0 ? k + 1 : n; // 第一个窗口的右开端点
        k = Math.abs(k);
        int s = 0;
        for (int i = r - k; i < r; i++) {
            s += code[i]; // 计算 ans[0]
        }
        for (int i = 0; i < n; i++) {
            ans[i] = s;
            s += code[r % n] - code[(r - k) % n];
            r++;
        }
        return ans;
    }
}
