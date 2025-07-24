import java.util.*;

public class SolutionLowestCommonAncestor {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == p || root == q || root == null) return root;
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        if(left != null && right !=null) return root;
//        if(left == null) return  right;
//        return  left;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        Map<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root,null);

        while (!map.containsKey(q) || !map.containsKey(p)){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
                map.put(node.left,node);
            }
            if(node.right != null){
                stack.push(node.right);
                map.put(node.right,node);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p!=null){
            ancestors.add(p);
            p= map.get(p);
        }

        while (q!=null){
            if(ancestors.contains(q)) break;
            q = map.get(q);
        }
        return q;
    }

}
