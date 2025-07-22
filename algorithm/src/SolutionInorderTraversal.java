import java.util.*;


public class SolutionInorderTraversal {
    // 递归算法
    // List<Integer> res = new ArrayList<>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     helper(root);
    //     return res;
    // }

    // private void helper(TreeNode root){
    //     if(root == null) return ;
    //     helper(root.left);
    //     res.add(root.val);
    //     helper(root.right);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur=root;
        while (!stack.isEmpty() || cur!=null) {
            // 把左孩子节点全部加入stack
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 没有左孩子节点了，弹出第一个节点
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
