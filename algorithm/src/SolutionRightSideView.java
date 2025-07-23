import java.util.*;

public class SolutionRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size>0){
                TreeNode node = deque.poll();
                size--;
                if(size==0) res.add(node.val);
                if(node.left!=null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
            }
        }
        return  res;
    }
}
