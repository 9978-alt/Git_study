public class SolutionCanJump {
    public boolean canJump(int[] nums) {
        int jump=nums[0];
        int cur = 1;
        if(jump == 0 && nums.length == 1) return true;
        while (jump > 0){
            jump--;
            cur++;
            if(cur >= nums.length) return true;
            jump = Math.max(jump,nums[cur-1]);
        }
        return false;
    }

    public static void main(String[] args) {
        SolutionCanJump solutionCanJump = new SolutionCanJump();
        System.out.println(solutionCanJump.canJump(new int[]{1}));
    }


}
