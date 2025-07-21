public class SolutionDiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        ans = depth(root);
        return ans-1;
        
    }

    private int depth(TreeNode node){
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans,L+R+1);
        return Math.max(L, R)+1;
    }
}
