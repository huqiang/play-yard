package qiang.hu.leetcode.solution;

/**
 * https://leetcode.com/problems/sum-of-beauty-in-the-array/description/
 */
public class LC2012 {
    public int sumOfBeauties(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        rightMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftMax[i - 1] && nums[i] < rightMin[i + 1]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }
        return sum;
    }
}
