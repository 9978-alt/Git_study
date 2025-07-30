import java.util.ArrayList;
import java.util.List;

public class SolutionPermute {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        helper(nums,visited,new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums,boolean[] visited,List<Integer> list){
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums,visited,list);
            visited[i] = false;
            if(list.size() == nums.length) ans.add(list);
        }
    }
}
