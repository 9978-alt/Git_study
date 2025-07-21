import java.util.*;

public class SolutionSpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int val=matrix.length * matrix[0].length;
        int top = 0, bottom = matrix.length-1,left = 0,right = matrix[0].length-1;
        while(true){
            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if(res.size() == val) break;
            top++;

            // 右侧 从上到下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if(res.size() == val) break;

            right--;

            // 下侧 从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if(res.size() == val) break;

            bottom--;

            // 左侧 从下到上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if(res.size() == val) break;

            left++;

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SolutionSpiralOrder solution = new SolutionSpiralOrder();
        List<Integer> res  = solution.spiralOrder(matrix);
        for (Integer integer : res) {
            System.out.print(integer + "\t");
        }
    }
}
