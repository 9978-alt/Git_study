import java.util.Deque;
import java.util.LinkedList;

public class SolutionIsSymmetric {
    // 递归做法
    public boolean isSymmetric1(TreeNode root){
        if(root == null) return true;
        return helper1(root.left,root.right);
    }

    private boolean helper1(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if((left == null || right == null) || left.val != right.val) return false;
        return helper1(left.left, right.right) && helper1(left.right, right.left);
    }

    // 迭代做法
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode root1,TreeNode root2){
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root1);
        deque.add(root2);
        while (!deque.isEmpty()) {
            TreeNode u = deque.poll();
            TreeNode v = deque.poll();
            if(u == null && v == null) continue;
            if((u == null || v == null) && u.val != v.val) return false;
            deque.add(u.left);
            deque.add(v.right);

            deque.add(u.right);
            deque.add(v.left);


        }
        return true;
    }
}
