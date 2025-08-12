public class SolutionMinDistance {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示从word[0...i]word[0...j]之间的最短编辑距离
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        SolutionMinDistance solutionMinDistance = new SolutionMinDistance();
        int distance = solutionMinDistance.minDistance("horse", "ros");
        System.out.println(distance);
    }
}
