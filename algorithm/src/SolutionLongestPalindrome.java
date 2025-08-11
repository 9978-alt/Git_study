public class SolutionLongestPalindrome {
//    public String longestPalindrome(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n]; // dp[i][j] 表示s中从i～j字符串是不是回文串
//        int maxlen = 1;
//        int start=0;
//        for (int i = 0; i < s.length(); i++) {
//            dp[i][i] = true;
//        }
//        // 上三角
//        for (int len = 2; len < s.length(); len++) {
//            for (int i = 0; i < s.length()-len; i++) {
//                int j = i+len-1;
//                if(len == 2){
//                    dp[i][j] = s.charAt(i)==s.charAt(j);
//                }else {
//                    dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
//                }
//                if(maxlen < len){
//                    maxlen = len;
//                    start = i;
//                }
//            }
//        }
//        return s.substring(start,start+maxlen);
//    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            // 模拟奇数和偶数序列的中心点
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                // 回到回文串的起始位置和结束位置
                l++;
                r--;
                if (maxlen < r - l + 1) {
                    maxlen = r - l + 1;
                    start = l;
                }
            }
        }

        return s.substring(start, start + maxlen);
    }

    public static void main(String[] args) {
        SolutionLongestPalindrome solutionLongestPalindrome = new SolutionLongestPalindrome();
        String s = solutionLongestPalindrome.longestPalindrome("cccc");
        System.out.println(s);
    }

}
