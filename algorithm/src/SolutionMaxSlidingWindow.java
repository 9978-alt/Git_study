import java.util.Deque;
import java.util.LinkedList;

public class SolutionMaxSlidingWindow {

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int length=nums.length;
    //     int[] res = new int[length-k+1];
    //     int right=0;
    //     int left=0;
    //     int m = 0;
    //     while (right < length) {
    //         int max = Integer.MIN_VALUE;
    //         while(right - left < k){
    //             right++;
    //         }
    //         int cur = left;
    //         while (cur < right) {
    //             max = max < nums[cur]?nums[cur]:max;
    //             cur++;
    //         }
    //         res[m++] = max;
    //         left++;
    //     }
    //     return res;
    // }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length=nums.length;
        int[] res = new int[length-k+1];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {   //先将前k-1个入栈
            while (!stack.isEmpty() && nums[i]>stack.peekLast()) {
                stack.removeLast();
            }
            stack.addLast(nums[i]);
        }
        res[0] = stack.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if(nums[i-k] == stack.peekFirst()){
                stack.removeFirst();
            }
            while (!stack.isEmpty() && nums[i]>stack.peekLast()) {
                stack.removeLast();
            }
            stack.addLast(nums[i]);
            res[i-k+1] = stack.peekFirst();
        }
        return res;
    }
     public static void main(String[] args) {
        SolutionMaxSlidingWindow solution = new SolutionMaxSlidingWindow();
        int[] res = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(int num:res){
            System.out.println(num);
        }
    }
}
