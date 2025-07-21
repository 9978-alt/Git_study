public class SolutionMaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionMaxSubArray solution = new SolutionMaxSubArray();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    
}