public class SolutionMaxPathSum {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        helper(root);
        return sum;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;  // 递归出口
        int left = 0,right = 0;
        left = Math.max(0,helper(root.left));
        right = Math.max(0,helper(root.right));
        sum = Math.max(sum,root.val+left+right);
        return Math.max(root.val+left,root.val+right);
    }
}
