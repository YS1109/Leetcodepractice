package question1421_1430;


// https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/
public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int totalPoints = 0;
        int n = cardPoints.length - k;
        for (int cardPoint : cardPoints) {
            totalPoints += cardPoint;
        }
        if (n == 0) {
            return totalPoints;
        }
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            currentSum += cardPoints[i];
            if (i < n - 1) {
                continue;
            }
            minSum = Math.min(minSum, currentSum);
            currentSum -= cardPoints[i - n + 1];
        }
        return totalPoints - minSum;
    }
}