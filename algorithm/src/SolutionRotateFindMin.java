public class SolutionRotateFindMin {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        if(nums[left]<nums[right]) return nums[left];
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){    // 中间元素大于右侧元素，说明最小值在右侧
                left = mid+1;
            }else { //中间元素小于等于右侧元素，最小值在左侧。
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        SolutionRotateFindMin solution = new SolutionRotateFindMin();
        System.out.print(solution.findMin(new int[]{3,1,2}));
    }
}
