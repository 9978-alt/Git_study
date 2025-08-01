public class SolutionSearchRotate {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                if(nums[left] < nums[mid]){    // 左侧有序
                    if(nums[left] > target){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }else {
                    right = mid-1;
                }
            }else {
                if(nums[mid] <= nums[right]){    // 右侧有序
                    if(nums[right] <target){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }else {
                    left = mid+1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionSearchRotate solution = new SolutionSearchRotate();

        // 测试用例1：基本旋转数组
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("测试用例1：");
        System.out.println("数组: [4, 5, 6, 7, 0, 1, 2]，目标值: " + target1);
        System.out.println("结果索引: " + solution.search(nums1, target1) + "（预期：4）\n");

        // 测试用例2：目标值不存在
//        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
//        int target2 = 3;
//        System.out.println("测试用例2：");
//        System.out.println("数组: [4, 5, 6, 7, 0, 1, 2]，目标值: " + target2);
//        System.out.println("结果索引: " + solution.search(nums2, target2) + "（预期：-1）\n");
//
//        // 测试用例3：未旋转的有序数组
//        int[] nums3 = {1, 2, 3, 4, 5};
//        int target3 = 3;
//        System.out.println("测试用例3：");
//        System.out.println("数组: [1, 2, 3, 4, 5]，目标值: " + target3);
//        System.out.println("结果索引: " + solution.search(nums3, target3) + "（预期：2）\n");
//
//        // 测试用例4：旋转点在首位
//        int[] nums4 = {1};
//        int target4 = 1;
//        System.out.println("测试用例4：");
//        System.out.println("数组: [1]，目标值: " + target4);
//        System.out.println("结果索引: " + solution.search(nums4, target4) + "（预期：0）\n");
//
//        // 测试用例5：旋转后左半部分无序
//        int[] nums5 = {5, 1, 3};
//        int target5 = 3;
//        System.out.println("测试用例5：");
//        System.out.println("数组: [5, 1, 3]，目标值: " + target5);
//        System.out.println("结果索引: " + solution.search(nums5, target5) + "（预期：2）");
    }

}
