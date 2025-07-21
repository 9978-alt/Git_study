import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SolutionLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            while (size>0) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                size--;
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
