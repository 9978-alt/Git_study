import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionWordBreak {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length()+1];
//        dp[0]=true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                String substr = s.substring(j,i);
//                if(dp[j] && wordDict.contains(substr)){
//                    dp[i]=true;
//                    break;
//                }
//            }
//
//        }
//        return dp[s.length()];
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            if(!dp[i]) continue;
            for (int j = 0; j < wordDict.size(); j++) {
                int len=wordDict.get(j).length();
                String str = s.substring(i,len);
                if(str.equals(wordDict.get(j))){
                    dp[i+len]=true;
                }
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        SolutionWordBreak solutionWordBreak = new SolutionWordBreak();
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean leetcode = solutionWordBreak.wordBreak("leetcode", wordDict);
        System.out.println(leetcode);
    }
}
