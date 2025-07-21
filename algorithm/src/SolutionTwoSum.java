import java.util.*;

public class SolutionTwoSum {

    // 暴力解法，O(n2)
    // public int[] twoSum(int[] nums, int target) {
    //     int[] res = new int[2];
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]+nums[j] == target){
    //                 res[0]=i;
    //                 res[1]=j;
    //                 return res; 
    //             }
    //         }
    //     }

    //     return new int[0];
    // }

    // public int[] twoSum(int[] nums, int target) {
    //     int[] res = new int[2];
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i = 0; i < nums.length;i++){
    //         map.put(nums[i], i);
    //     }

    //     for(int i = 0;i < nums.length;i++){
    //         if(map.containsKey(target-nums[i])){
    //             res[0] = i;
    //             res[1] = map.get(target-nums[i]);
    //             return res;
    //         }
    //     }
    
    //     return new int[0];
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    // public static void main(String[] args) {
        
    // }
}