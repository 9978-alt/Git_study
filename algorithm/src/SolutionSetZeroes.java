public class SolutionSetZeroes {
    // public void setZeroes(int[][] matrix) {
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     int[] rowzero = new int[row];
    //     int[] colzero = new int[col];

        
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if(matrix[i][j] == 0){
    //                 rowzero[i] = rowzero[i] == 0? ++rowzero[i]:rowzero[i];
    //                 colzero[j] = colzero[j] == 0? ++colzero[j]:colzero[j];
    //                 System.out.print(rowzero[i] + "\t" + colzero[j]+"\n");
    //             }
    //         }
    //     }

    //     for (int i = 0; i < rowzero.length; i++) {
    //         if(rowzero[i] == 0) continue;
    //         for (int j = 0; j < col; j++) {
    //             matrix[i][j] = 0;
    //         }
    //     }

    //     for (int i = 0; i < colzero.length; i++) {
    //         if(colzero[i] == 0) continue;
    //         for (int j = 0; j < row; j++) {
    //             matrix[j][i] = 0;
    //         }
    //     }
    // }


    public void setZeroes(int[][] matrix) {
        boolean flag = false; // 用来判断第一个行是否有0
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                flag = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {    // 用matrix[0][0]判断第一列是否有0
            if(matrix[i][0] == 0){
                matrix[0][0] =0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; // 第一列对应置0
                    matrix[0][j] = 0; // 第一行对应置0
                }
            }
        }

        for (int i = matrix[0].length-1; i >= 0; i--) {
            for (int j = matrix.length-1; j >=1; j--) {
                if(matrix[0][i] == 0 || matrix[j][0] == 0){
                    matrix[j][i]=0;
                }
            }
        }

        if(flag){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SolutionSetZeroes solution = new SolutionSetZeroes();
        solution.setZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
