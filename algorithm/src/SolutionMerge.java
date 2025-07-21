import java.util.*;


public class SolutionMerge {
    // 排序
    // public int[][] merge(int[][] intervals) {
    //     Arrays.sort(intervals, new Comparator<int[]>() {
    //         @Override
    //         public int compare(int[] o1, int[] o2) {
    //             return o1[0]-o2[0];
    //         }
    //     });
    //     List<int[]> res = new ArrayList<>();
    //     int leftVal = intervals[0][0];
    //     int rightVal = intervals[0][1];
    //     int i = 0;
    //     while (i < intervals.length) {
    //         while (i < intervals.length && intervals[i][0] <= rightVal) {
    //             rightVal = Math.max(rightVal, intervals[i][1]);
    //             i++;
    //         }
    //         res.add(new int[]{leftVal,rightVal});
    //         if(i < intervals.length){
    //             leftVal = intervals[i][0];
    //             rightVal = intervals[i][1];
    //         }
            
    //     }

    //     return res.toArray(new int[0][]);
    // }

    // 差分数组
    public int[][] merge(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }

        int[] diff = new int[max*2+2];

        for (int i = 0; i < intervals.length; i++) {
            diff[intervals[i][0] * 2]++;    // 左端点加
            diff[intervals[i][1] * 2+1]--;  // 右端点减
        }

        int[][] res = new int[intervals.length][2];
        int flag = 0;
        int k =0;
        for (int i = 0; i < diff.length; i++) {
            int cur = diff[i];
            flag += cur;
            if(flag > 0 && flag == cur){  // 找到左端点
                res[k][0] = i / 2;
            }else if (flag == 0 && cur < 0){    // 找到右端点
                res[k][1] = i / 2;
                k++;
            }
        }
        return Arrays.copyOf(res, k);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        SolutionMerge solution = new SolutionMerge();
        int res[][] = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
