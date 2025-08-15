import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTopKFrequent {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> frequent = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0) + 1);
//        }
//        Integer[] arr = frequent.keySet().toArray(new Integer[0]);
//        buildMaxHeap(arr, frequent, arr.length);
//        int[] ans = new int[k];
//        int n=0;
//        int heapSize=arr.length;
//        for (int i = arr.length-1; i >= arr.length - k+1 ; i--) {
//            ans[n++]=arr[0];
//            swap(arr,0,i);
//            --heapSize;
//            justifyMaxHeap(arr,frequent,0,heapSize);
//        }
//        return ans;
//    }
//
//    private void buildMaxHeap(Integer[] arr, Map<Integer, Integer> frequent, int length) {
//        for (int i = length / 2 - 1; i >= 0; i--) {
//            justifyMaxHeap(arr, frequent, i, length);
//        }
//    }
//
//    private void justifyMaxHeap(Integer[] arr, Map<Integer, Integer> frequent, int i, int heapSize) {
//        int l = 2 * i + 1, r = 2 * i + 2,largest = i;
//        if(l < heapSize && frequent.get(arr[l]) > frequent.get(arr[largest])) largest = l;
//        if(r < heapSize && frequent.get(arr[r]) > frequent.get(arr[largest])) largest = r;
//        if(largest != i){
//            swap(arr,largest,i);
//            justifyMaxHeap(arr,frequent,largest,heapSize);
//        }
//    }
//    public void swap(Integer[] nums,int l,int r){
//        int temp = nums[l];
//        nums[l]=nums[r];
//        nums[r]=temp;
//    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] list = new List[nums.length+1];
        for(int key:frequent.keySet()){
            Integer i = frequent.get(key);
            if(list[i] == null){
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        int[] res=new int[k];
        int n=0;
        for (int i = nums.length-1; i >= 0 && n <k ; i--) {
            if(list[i] == null)continue;
            for(int num:list[i]) res[n++]=num;
        }
        return res;
    }

}
