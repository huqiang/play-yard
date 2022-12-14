package qiang.hu.leetcode.solution;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
