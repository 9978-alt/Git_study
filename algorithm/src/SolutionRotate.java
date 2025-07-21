public class SolutionRotate {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);    
    }

    private void reverse(int nums[], int left,int right){
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        SolutionRotate solution = new SolutionRotate();
        int nums[] = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        for(int integer : nums){
            System.out.print(integer +"\t");
        }
    }
}
