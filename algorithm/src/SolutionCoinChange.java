import java.util.Arrays;

public class SolutionCoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        SolutionCoinChange change = new SolutionCoinChange();
        int coinChange = change.coinChange(new int[]{2}, 3);
        System.out.println(coinChange);
    }

}
