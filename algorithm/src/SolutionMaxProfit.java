public class SolutionMaxProfit {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        SolutionMaxProfit solutionMaxProfit = new SolutionMaxProfit();
        System.out.println(solutionMaxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
