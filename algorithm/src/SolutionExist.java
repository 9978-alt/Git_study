public class SolutionExist {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    boolean ans;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    traceback(board, word, 0, 0, 0,new StringBuilder());
                }
            }
        }
        return ans;
    }

    private void traceback(char[][] board, String word, int i, int j, int p,StringBuilder sb) {
        if(p == word.length()){
            ans = true;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < dx.length; k++) {
            int x = i+dx[i];
            int y = j + dx[j];
            if(x < 0 || x >= board.length || y < 0 || y>=board[0].length || visited[x][y] || board[x][y] != word.charAt(p+1)) continue;
            visited[x][y] = true;
            traceback(board,word,x,y,p+1,sb);
            visited[x][y] = false;
        }
        visited[i][j] = false;
    }


}
