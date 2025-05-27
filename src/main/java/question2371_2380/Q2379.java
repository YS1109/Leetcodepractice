package question2371_2380;

//https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

public class Q2379 {
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        char[] blocksCharArray = blocks.toCharArray();
        int currentRecolors = 0;
        for (int i = 0; i < blocksCharArray.length; i++) {
            currentRecolors += blocksCharArray[i] == 'W' ? 1 : 0;
            if (i < k - 1 ) {
                continue;
            }
            ans = Math.min(ans, currentRecolors);
            currentRecolors -= blocksCharArray[i - k + 1] == 'W' ? 1 : 0;
        }
        return ans;
    }
}
