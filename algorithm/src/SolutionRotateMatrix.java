public class SolutionRotateMatrix {
    public void rotate(int[][] matrix) {
        // {0,1}->{1,3}, {1,3}->{3,3-1}

        int top = 0,bottom = matrix.length-1,left = 0,right = matrix[0].length-1;

        while (top < bottom && right > left) {
            
            // 从开始轮换的第一行开始，遍历第一行的所有元素，进行轮换
            for (int i = left; i < right; i++) {
                int val = matrix[top][i];
                int offset = i - left;
                matrix[top][i] = matrix[bottom - offset][left];
                matrix[bottom - offset][left] = matrix[bottom][bottom - offset];
                matrix[bottom][bottom - offset] = matrix[i][right];
                matrix[i][right] = val;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        SolutionRotateMatrix solution = new  SolutionRotateMatrix();
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
