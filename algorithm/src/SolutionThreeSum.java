import java.util.*;

public class SolutionThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>>  ans = new HashSet<>();
        for (int k = 0; k < nums.length-2; k++) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = k+1; i < nums.length; i++) {
                List<Integer> res=new ArrayList<>();
                if(map.containsKey(0-nums[k]-nums[i])){
                    res.add(nums[i]);
                    res.add(0-nums[k]-nums[i]);
                    res.add(nums[k]);
                    Collections.sort(res);
                    ans.add(res);
                }else{
                    map.put(nums[i], i);
                }
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        SolutionThreeSum solution = new SolutionThreeSum();
        List<List<Integer>> res = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }
    }
}
