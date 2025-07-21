
public class SolutionFirstMissingPositive {
    // public int firstMissingPositive(int[] nums) {
    //     int res = 1;
    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i]>0) set.add(nums[i]);
    //     }
    //     while (true) {
    //         if(set.contains(res)) res++;
    //         else return res;
    //     }

    // }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > n){
                nums[i] = n+1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (cur > n) continue;
            else {
                nums[cur-1] = nums[cur-1] < 0?nums[cur-1]:0-nums[cur-1];
            }
        }


        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        SolutionFirstMissingPositive solution = new SolutionFirstMissingPositive();
        System.out.println(solution.firstMissingPositive(new int[]{1,1}));
    }
    
}