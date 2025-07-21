public class SolutionProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = nums[i-1] * answer[i-1];
            // System.out.print(answer[i] + "\t");
        }

        int cur = 1;
        for (int i = nums.length-1; i >=0; i--) {
            answer[i] = answer[i] * cur;
            cur *= nums[i];
        }


        return answer;
    }

    public static void main(String[] args) {
        SolutionProductExceptSelf solution = new SolutionProductExceptSelf();
        int[] res = solution.productExceptSelf(new int[]{1,2,3,4});
        for(int num:res){
            System.err.print(num+"\t");
        }
    }
    
}