import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SolutionPathSum {
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//
//        int ret = rootSum(root, targetSum);
//        ret += pathSum(root.left, targetSum);
//        ret += pathSum(root.right, targetSum);
//        return ret;
//    }
//
//    private int rootSum(TreeNode root, int targetSum) {
//        int ret = 0;
//        if (root == null) {
//            return 0;
//        }
//        if (root.val == targetSum) ret++;
//
//        ret += rootSum(root.left, targetSum - root.val);
//        ret += rootSum(root.right, targetSum - root.val);
//        return ret;
//    }

    Map<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        return dfs(root,targetSum,0);
    }

    private int dfs(TreeNode root,long targetSum,long preSum){
        if(root == null) return 0;
        //更新节点和
        preSum += root.val;
        int pathSum = map.getOrDefault(preSum-targetSum,0);
        map.put(preSum,map.getOrDefault(preSum,0)+1);
        pathSum+=dfs(root.left,targetSum,preSum)+dfs(root.right,targetSum,preSum);
        map.put(preSum,map.get(preSum)-1);//回溯
        return  pathSum;
    }


}
