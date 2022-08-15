package leetcodetest;

import org.junit.Test;
import question11_20.Q15;
import question1_10.Q6;

public class LeetCodeTest {

    @Test
    public void Q15Test(){
        Q15 q15 = new Q15();
        int[] nums = new int[]{3,0,-2,-1,1,2};
        System.out.println(q15.threeSum(nums));
    }
}
