
public class SolutionSearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 在第一列中找到第一个大于taget/ 最后一个小于target的数 
        // int row = -1;
        // for (int i = 0; i < matrix.length-1; i++) {
        //     if(matrix[i][0] < target && matrix[i+1][0] > target){
        //         row = i;
        //         break;
        //     }
        // }
        // row = row == -1? matrix.length-1 : row;
        // if (matrix[row][matrix[0].length-1] < target) return false;
        // int left = 0,right = matrix[0].length;
        // while (left <= right) {
        //     int mid  = (left + right) / 2;
        //     if(matrix[row][mid]<target){
        //         left = mid;
        //     }else if (matrix[row][mid] > target){
        //         right = mid;
        //     }else {
        //         return true;
        //     }
        // }
        // return false;
        int row = 0,col = matrix[0].length-1;
        while (row < matrix.length && col >=0) {
            if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }else {
                return true;
            }
        }
        return false;
    }
}
