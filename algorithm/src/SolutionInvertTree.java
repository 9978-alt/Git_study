import java.util.Deque;
import java.util.LinkedList;

public class SolutionInvertTree {
    // 递归做法
    public TreeNode invertTree1(TreeNode root) {
        return helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root == null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        helper(root.left);
        helper(root.right);
        return root;
    }

    // 非递归做法
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
                size--;
            }
        }
        return root;
    }
}
