import java.util.*;

public class SolutionSubarraySum {

    // public int subarraySum(int[] nums, int k) {
    //     int res=0;
    //     for (int right = 0; right < nums.length; right++) {
    //         int sum=0;
    //         for (int left=right; left >=0 ; left--) {
    //             sum+=nums[left];
    //             if(sum == k){
    //                 res++;
    //                 break;
    //             }

    //         }
    //     }

    //     return res;
    // }

    public int subarraySum(int[] nums, int k) {
        int res=0;
        int pre=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(k-nums[i])){
                res += map.get(k-nums[i]);
            }
            pre += nums[i];
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }

        return res;
    }


    public static void main(String[] args) {
        SolutionSubarraySum solution = new SolutionSubarraySum();
        int res = solution.subarraySum(new int[]{1,2,3}, 3);
        System.out.println(res);
    }
}