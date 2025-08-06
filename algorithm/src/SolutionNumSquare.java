import java.util.Arrays;
import java.util.Map;

public class SolutionNumSquare {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*j <= i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        SolutionNumSquare solutionNumSquare = new SolutionNumSquare();
        int numSquares = solutionNumSquare.numSquares(12);
        System.out.println(numSquares);
    }

}
