import java.util.*;

public class SolutionKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if(k == 0) return cur.val;
            cur = cur.right;

        }
        return -1;
    }   
}
