import java.util.Arrays;

public class SolutionCanPartition {
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 != 0)
//            return false;
//        return helper(nums, sum / 2, 0);
//    }
//
//    private boolean helper(int[] nums, int target, int start) {
//        if (target == 0)
//            return true;
//        if (start >= nums.length || target < 0)
//            return false;
//        if (helper(nums, target - nums[start], start + 1))
//            return true;
//        return helper(nums, target, start + 1);
//    }
//    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if(sum % 2 != 0) return false;
//        int[][] memo = new int[nums.length][sum/2+1];
//        for(int[] row : memo){
//            Arrays.fill(row,-1);// 表示从来没有计算过
//        }
//        return dfs(nums.length-1,sum/2,nums,memo);
//    }
//    // dfs(i,j)表示从nums[0] 到 nums[i]能否有等于j的子序列
//    private boolean dfs(int i,int j,int[] nums,int[][] memo){
//        // j 从 sum/2 开始递减，如果i<0，j=0，那么说明找到了一个子序列，否则，没有找到
//        if(i < 0) return  j == 0;
//        // 如果从nums[0] 到 nums[i]已经计算过了，那就判断是否为1，1表示有该子序列。
//        if(memo[i][j] != -1) return memo[i][j]==1;
//        // dfs(i-1,j-nums[i],nums,memo) 表示选nums[i],dfs(i-1,j,nums,memo)表示不选nums[i]
//        boolean res = j >= nums[i] && dfs(i-1,j-nums[i],nums,memo) || dfs(i-1,j,nums,memo);
//        memo[i][j] = res?1:0;
//        return res;
//    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        sum = sum / 2;
        // f[i][j]表示能否有子序列 nums[0] ~ nums[i]和为j
        boolean[][] f = new boolean[nums.length+1][sum];
        f[0][0]=true;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = 0; j < sum; j++) {
                f[i+1][j] = j>=x && f[i][j-x] || f[i][j];
            }

        }
        
        return f[nums.length][sum/2];
    }


}
