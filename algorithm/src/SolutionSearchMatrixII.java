public class SolutionSearchMatrixII {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int left=0,right = matrix.length-1;
//        // 先搜索行，定位taregt可能所在的行
//        while (left <= right){
//            int mid = left+(right-left)/2;
//            if(matrix[mid][0] == target){
//                return true;
//            } else if (matrix[mid][0] > target) {
//                right = mid-1;
//            }else {
//                left = mid+1;
//            }
//        }
//        int row = right;
//        left = 0;
//        right = matrix[0].length-1;
//        while (left <= right){
//            int mid = left+(right-left)/2;
//            if(matrix[row][mid] == target){
//                return true;
//            } else if (matrix[row][mid] > target) {
//                right = mid-1;
//            }else {
//                left = mid+1;
//            }
//        }
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

}
