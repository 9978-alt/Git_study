public class SolutionSortedArrayToBST {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dummy = new TreeNode();
        dummy.left = helper(nums, 0, nums.length-1);
        return dummy.left;
    }

    public TreeNode helper(int[] nums,int left,int right){
        if(left < right) return null;
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = helper(nums, left, mid-1);
        midNode.right = helper(nums, mid+1, right);
        return midNode;
    }
}
