public class SolutionJump {

    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int end = nums[0],curEnd = end,step=1;
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end,i+nums[i]);
            if(curEnd >= nums.length-1) break;
            if(i == curEnd){
                step++;
                curEnd = end;
            }

        }
        return step;
    }

    public static void main(String[] args) {
        SolutionJump solutionCanJump = new SolutionJump();
        System.out.println(solutionCanJump.jump(new int[]{1,2,3}));
    }

}
