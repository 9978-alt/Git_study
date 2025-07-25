import java.util.Deque;
import java.util.LinkedList;

public class SolutionNumsIsland {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid,int i,int j){
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{i,j});
        while (!deque.isEmpty()){
            int[] pos = deque.poll();
            int x = pos[0],y = pos[1];
            grid[x][y] = '0';
            for (int k = 0; k < dx.length; k++) {
                int m=x+dx[k],n=y+dy[k];
                if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == '0') continue;
                deque.add(new int[]{m,n});
            }
        }
    }



//    public int numIslands(char[][] grid) {
//        int m = grid.length,n = grid[0].length;
//        int ans = 0;
//        boolean[][] visited = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(grid[i][j] == '1' && !visited[i][j]){
//                    dfs(grid,i,j,visited);
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//    private void dfs(char[][] grid,int x,int y,boolean[][] visited){
//        visited[x][y] = true;
//        for (int i = 0; i < dx.length; i++) {
//            int d_x = x+dx[i];
//            int d_y = y+dy[i];
//            if(d_x<0 || d_x>=grid.length || d_y<0 || d_y>=grid[0].length || visited[d_x][d_y] || grid[d_x][d_y]!='1') continue;
//            dfs(grid,d_x,d_y,visited);
//        }
//    }


}
