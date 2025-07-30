import java.util.ArrayList;
import java.util.List;

public class SolutionCombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 1 && target!=candidates[0]) return ans;
        traceback(candidates,target,0,0,new ArrayList<>());
        return ans;
    }

    private void traceback(int[] candicates,int target,int sum,int pos,List<Integer> list){
        if(sum>target) return;
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < candicates.length; i++) {
            list.add(candicates[i]);
            sum+=candicates[i];
            traceback(candicates,target,sum,i,list);
            list.remove(list.size()-1);
            sum-=candicates[i];
        }
    }
}
