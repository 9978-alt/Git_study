public class SolutionSortColor {
//    public void sortColors(int[] nums) {
//        int one = 0,two=0;
//        int k=0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == 1) one++;
//            else if (nums[i] == 2) two++;
//            else nums[k++]=0;
//        }
//
//        for (int i = 0; i < one; i++) {
//            nums[k++]=1;
//        }
//        for (int i = 0; i < two; i++) {
//            nums[k++]=2;
//        }
//    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0=0,p1 = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1]=temp;
                }
                ++p1;
                ++p0;
            }
        }
    }

}
