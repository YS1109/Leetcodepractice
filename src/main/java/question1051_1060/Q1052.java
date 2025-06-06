package question1051_1060;

public class Q1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int currentSum = 0;
        int maxGrumpySum = Integer.MIN_VALUE;
        int maxGrumpyStart = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentSum += customers[i];
            }
            if (i < minutes - 1) {
                continue;
            }
            if (currentSum > maxGrumpySum) {
                maxGrumpySum = currentSum;
                maxGrumpyStart = i;
            }
            if (grumpy[i - minutes + 1] == 1) {
                currentSum -= customers[i - minutes];
            }
        }

        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i >= maxGrumpyStart && i < maxGrumpyStart + minutes && grumpy[i] == 1) {
                continue;
            }
            ans += grumpy[i] == 0 ? customers[i] : 0;
        }
        return ans + maxGrumpySum;
    }
}
