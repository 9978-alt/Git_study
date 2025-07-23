public class SolutionFlatten {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur!=null){
            if(cur.left == null) {
                cur = cur.right;
            }
            TreeNode right = cur.right; // 标记右子树
            if(right == null){
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
                continue;
            }
            // 找到左孩子节点的最右下节点
            TreeNode tmp = cur.left;
            while (tmp.right!=null){
                tmp = tmp.right;
            }
            tmp.right = right;
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }
    }

//    public static void main(String[] args) {
//
//    }
}
