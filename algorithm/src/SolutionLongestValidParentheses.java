public class SolutionLongestValidParentheses {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()]; // dp[i]表示以 i 为结尾的最长有效括号子串的长度
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
