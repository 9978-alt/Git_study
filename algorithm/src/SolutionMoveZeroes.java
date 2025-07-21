
public class SolutionMoveZeroes {

        public void moveZeroes(int[] nums) {
            if(nums.length == 0 || nums.length == 1) return;
            
            int nonZero=0;
            int k =0;
            while (nonZero < nums.length) {
                if (nums[nonZero] != 0){
                    nums[k++] = nums[nonZero]; 
                }
                nonZero++;
            }
            while (k<nums.length) {
                nums[k++] = 0;
            }
        }

        public static void main(String[] args) {
            SolutionMoveZeroes solution = new SolutionMoveZeroes();
            int[] nums  = new int[]{0,1,0,3,12};
            solution.moveZeroes(nums);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + "\t");
            }
        }
}