public class SolutionTrap {
    public int trap(int[] height) {
        int res =0;

        int left=0,right=height.length-1,leftMax=0,rightMax=0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] < height[right]){
                res += leftMax - height[left];
                left++;
            }else{
                res += rightMax-height[right];
                right--;
            }
        }
        

        return res;
        
    }

    public static void main(String[] args) {
        SolutionTrap solution = new SolutionTrap();
        System.out.println(solution.trap(new int[]{4,2,3}));
    }
}