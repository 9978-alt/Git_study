import java.util.*;

public class SolutionLongestConsecutive {

    // public int longestConsecutive(int[] nums) {
    //     int len=1;
    //     Set<Integer> set = new HashSet<>();
    //     for(int num:nums){
    //         set.add(num);
    //     }
        
    //     for(int num :set){
    //         if(!set.contains(num-1)){
    //             int curNum=num;
    //             int curLen = 1;
    //             while (set.contains(curNum+1)) {
    //                 curLen++;
    //                 curNum++;
    //             }

    //              len = Math.max(curLen, len);
    //         }

           

    //     }
    //     return len;
    // }

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num, 0);
                
                res = Math.max(res, left+right+1);

                map.put(num, left+right+1);
                map.put(num-left, left+right+1);
                map.put(num+right, left+right+1);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        SolutionLongestConsecutive solution = new SolutionLongestConsecutive();
        System.out.println(solution.longestConsecutive(nums));
    }
    
}
