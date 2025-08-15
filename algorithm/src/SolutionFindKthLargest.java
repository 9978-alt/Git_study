import java.util.Deque;
import java.util.PriorityQueue;

public class SolutionFindKthLargest {
    // 优先队列
//    public int findKthLargest(int[] nums, int k) {
//        // 元素按照从小到大的顺序排
//        int ans = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(queue.size() == k){
//                queue.add(Math.max(queue.poll(),nums[i]));
//                ans = queue.peek();
//            }else {
//                queue.add(nums[i]);
//            }
//        }
//        return ans;
//    }

    // 大根堆
//    public int findKthLargest(int[] nums, int k) {
//        int length = nums.length;
//        buildMaxHeap(nums,length);
//        for (int i = length-1; i >= length-k-1; i--) {
//            swap(nums,0,i);
//            length--;
//            justifyMaxHeap(nums,0,length);
//        }
//        return nums[0];
//    }
//
//    public void buildMaxHeap(int[] nums, int heapSize) {
//        // 从最后一个非叶子节点开始调整
//        for (int i = heapSize / 2 - 1; i >= 0; i--) {
//            justifyMaxHeap(nums, i, heapSize);
//        }
//
//    }
//
//    public void justifyMaxHeap(int[] nums, int i, int heapSize) {
//        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
//        if(nums[largest] < nums[l]){
//            largest = l;
//        }
//        if(nums[largest] < nums[r]){
//            largest = r;
//        }
//        if(largest != i){
//            // 交换位置
//            swap(nums,largest,i);
//            // 继续向下调整
//            justifyMaxHeap(nums,largest,heapSize);
//        }
//    }
//
    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }


    // 快速选择
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums,0,n-1,n-k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if(l == r) return nums[k];
        int x = nums[l],i=l-1,j=r+1;
        while (i < j){
            do i++; while (nums[i] < nums[x]);
            do j--; while (nums[j] > nums[x]);
            if(i < j) swap(nums,i,j);
        }
        if( j >= k) return quickSelect(nums,l,j,k);
        else return quickSelect(nums,j+1,r,k);
    }
}
