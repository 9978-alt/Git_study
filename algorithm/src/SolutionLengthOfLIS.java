import java.util.Arrays;
import java.util.Map;

public class SolutionLengthOfLIS {
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,1);
//        int maxLength = 1;
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = 0; j < i; j++) {
//                if(nums[j] < nums[i]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            maxLength = Math.max(maxLength,dp[i]);
//        }
//        return maxLength;
//    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];    // dp[i]表示长度为i的最长子序列的结尾元素的最小值
        Arrays.fill(dp,1);
        int maxLength = 1;
        dp[maxLength]= nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[maxLength]){
                dp[++maxLength]=nums[i];
            }else {
                int l = 1,r=maxLength,p=0;
                while (l<=r){
                    int mid = l+(r-l)>>1;
                    if(dp[mid] < nums[i]){
                        l=mid+1;
                        p=mid;
                    }else {
                        r=mid-1;
                    }
                }
                dp[p+1]=nums[i];
            }
        }
        return maxLength;


    }
}
