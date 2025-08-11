import java.util.Arrays;

public class SolutionUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列
        dp[0][0]=0;
        Arrays.fill(dp[0],1);
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        SolutionUniquePaths solutionUniquePaths = new SolutionUniquePaths();
        int uniquePaths = solutionUniquePaths.uniquePaths(3, 7);
        System.out.println(uniquePaths);
    }
}
