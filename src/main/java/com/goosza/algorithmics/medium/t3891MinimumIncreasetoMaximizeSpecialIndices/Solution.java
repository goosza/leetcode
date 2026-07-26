package com.goosza.algorithmics.medium.t3891MinimumIncreasetoMaximizeSpecialIndices;

public class Solution {
    public long minIncrease(int[] nums) {
        int prev2Count = 0, prev1Count = 0;
        long prev2Cost = 0, prev1Cost = 0;
        for (int i = 1; i <= nums.length - 2; i++) {
            int countA = prev1Count;
            long costA = prev1Cost;

            int countB = prev2Count + 1;
            long costB = prev2Cost + cost(nums, i);

            int curCount;
            long curCost;

            if (countB > countA || (countB == countA && costB < costA)) {
                curCount = countB;
                curCost = costB;
            } else {
                curCount = countA;
                curCost = costA;
            }

            prev2Count = prev1Count;
            prev2Cost = prev1Cost;
            prev1Count = curCount;
            prev1Cost = curCost;
        }

        return prev1Cost;
    }

    public int cost(int[] nums, int i) {
        if (isAlreadySpecial(nums, i)) return 0;
        return Math.max(nums[i-1], nums[i+1]) - nums[i] + 1;
    }

    public boolean isAlreadySpecial(int[] nums, int i) {
        return (nums[i] > nums[i-1] && nums[i] > nums[i+1]);
    }
}
