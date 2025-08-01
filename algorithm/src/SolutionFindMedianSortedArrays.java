import java.util.Map;

public class SolutionFindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        double res = 0;
        if (sum % 2 != 0) {
            res = getKMinValue(nums1, nums2, sum / 2+1);
        } else {
            res += getKMinValue(nums1, nums2, sum / 2);
            res += getKMinValue(nums1, nums2, sum / 2 + 1);
        }
        return res;
    }

    private int getKMinValue(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 处理边界情况
            if (index1 == n1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, n1) - 1;
            int newIndex2 = Math.min(index2 + half, n2) - 1;
            int pivot1 = nums1[newIndex1],pivot2=nums2[newIndex2];
            if(pivot1 < pivot2){
                k-=(newIndex1-index1+1);
                index1 = newIndex1+1;
            }else {
                k-=(newIndex2-index2+1);
                index2 = newIndex2+1;
            }
        }
    }
}
