import java.util.Deque;
import java.util.LinkedList;

public class SolutionMaxDepth {

    // 递归做法
    public int maxDepth_1(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root,int height){
        if(root == null) return height;
        height+=1;
        return Math.max(helper(root.left, height),helper(root.right, height));
    }

    // 迭代
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                if(node.left != null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
                size--;
            }
            res++;
        }
        return res;
    }

    
}
