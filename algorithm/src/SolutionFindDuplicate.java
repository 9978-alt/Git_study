public class SolutionFindDuplicate {

//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int l = 1, r = n, ans = -1;
//        while (l <= r) {
//            int mid = (l + r) >> 1;
//            int cnt = 0;
//            for (int i = 0; i < n; i++) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//            if (cnt <= mid) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//                ans = mid;
//            }
//        }
//        return ans;
//    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre2 != pre1) {
            pre2 = nums[pre2];
            pre1 = nums[pre1];
        }
        return pre1;
    }

    public static void main(String[] args) {
        SolutionFindDuplicate solutionFindDuplicate = new SolutionFindDuplicate();
        int duplicate = solutionFindDuplicate.findDuplicate(new int[]{1, 2, 3, 4, 5, 5});
        System.out.println(duplicate);
    }

}
