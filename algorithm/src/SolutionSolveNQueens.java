import java.util.ArrayList;
import java.util.List;

public class SolutionSolveNQueens {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        traceback(0, n, 1);
        return ans;
    }

    private void traceback(int x, int n, int curN) {
        if(x == n){
            saveStringtoList();
        }
        for (int j = 0; j < n; j++) {
            // 检查同列和斜线上是否有皇后
            boolean col = checkSameColumn(x, j);
            boolean diagonal = checkDiagonal(x, j, n);
            if (!col || !diagonal) continue; // 同列或者斜线上存在皇后
            board[x][j] = 'Q';
            traceback(x+1,n,curN+1);
            board[x][j] = '.';
        }

    }

    private void saveStringtoList() {
        List<String> list = new ArrayList<>();
        for(char[] row : board){
            list.add(new String(row));
        }
        ans.add(list);
    }

    private boolean checkSameColumn(int x,int y) {
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') return false;
        }
        return true;
    }

    private boolean checkDiagonal(int x, int y, int n) {
        // 检查左上对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 检查右上对角线
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;

    }
}
