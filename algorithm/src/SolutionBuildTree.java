import java.util.Deque;
import java.util.LinkedList;

public class SolutionBuildTree {

    // 递归做法
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
//    }
//
//    private TreeNode buildTree(int[] preoder, int[] inorder ,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
//        if(preorder_left > preorder_right){
//            return  null;
//        }
//        // 先序的第一个就是根节点
//        TreeNode root = new TreeNode(preoder[preorder_left]);
//
//        // 找到在中序遍历中根节点值的位置
//        int root_index = indexOfInorder(inorder,preoder[preorder_left]);
//        // 找到左孩子节点的个数
//        int left_size = root_index-inorder_left;
//        root.left = buildTree(preoder,inorder,preorder_left+1,preorder_left+left_size,inorder_left,root_index-1);
//        root.right = buildTree(preoder,inorder,preorder_left+left_size+1,preorder_right,root_index+1,inorder_right);return root;
//    }
//
//    private int indexOfInorder(int[] inorder,int target){
//        for (int i = 0; i < inorder.length; i++) {
//            if(inorder[i] == target) return i;
//        }
//        return  -1;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<TreeNode> stack = new LinkedList<>();
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
