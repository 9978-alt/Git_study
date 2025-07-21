public class SolutionIsValidBST {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
    private boolean check(TreeNode root,Integer lower,Integer higher){
        if(root == null) return true;
        if(lower != null && root.val <= lower) return false;
        if(higher!=null && root.val >= higher) return false;
        boolean left = check(root.left,lower,root.val);
        boolean right = check(root.right,root.val,higher);
        return left & right;
    }
}
