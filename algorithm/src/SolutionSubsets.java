import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.TreeSet;

public class SolutionSubsets {
    // 回溯做法
//    List<List<Integer>> ans = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums.length == 0){
//            ans.add(new ArrayList<>());
//            return ans;
//        }
//        traceback(nums,new ArrayList<>(),0);
//        return ans;
//    }
//
//    private void traceback(int[] nums,List<Integer> list,int i){
//        ans.add(list);
//        for (int j = i; j < nums.length ; j++) {
//            list.add(nums[j]);
//            traceback(nums,list,j+1);
//            list.remove(list.size()-1);
//        }
//    }

    // 二进制做法
//    public List<List<Integer>> subsets(int[] nums) {
//        List<Integer> t = new ArrayList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//
//        int n = nums.length;
//        for (int mask = 0; mask < (1 << n); mask++) {
//            t.clear();
//            for (int i = 0; i < n; ++i) {
//                // if the i-th bit of mask is 1, then add nums[i] to the current subset
//                if((mask & (1 << i)) != 0) t.add(nums[i]);
//            }
//            ans.add(new ArrayList<>(t));
//        }
//        return ans;
//    }

    //迭代做法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newsub = new ArrayList<>(ans.get(j));
                newsub.add(nums[i]);
                ans.add(newsub);
            }
        }
        return ans;
    }

}
