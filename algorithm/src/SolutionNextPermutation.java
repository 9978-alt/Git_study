import java.util.Arrays;

public class SolutionNextPermutation {
    public void nextPermutation(int[] nums) {
        int index=nums.length-2;
        // 找到第一个非递减排列的数
        while ((index == nums.length-1 || nums[index] >= nums[index+1]) && index >= 0){
            index--;
        }
        if(index < 0){
            reverse(nums,0,nums.length-1);
            return;
        }
        // 找到大于index数字的最小数
        int j = nums.length-1;
        while (nums[j] <= nums[index]){
            j--;
        }
        swap(nums,j,index);
        // 将index后的内容进行翻转
        reverse(nums,index+1,nums.length-1);
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public void reverse(int[] nums,int start,int end){
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        SolutionNextPermutation solutionNextPermutation = new SolutionNextPermutation();
        int[] nums = new int[]{1,2,3};
        solutionNextPermutation.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
