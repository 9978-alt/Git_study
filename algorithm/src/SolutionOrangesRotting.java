import java.util.Deque;
import java.util.LinkedList;

public class SolutionOrangesRotting {
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Deque<int[]> deque = new LinkedList<>();
        int fresh = 0;
        int minute = 0;
        // 先把所有的坏橘子都放入队列中并统计新鲜橘子的数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) deque.add(new int[]{i, j});
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        //遍历队列中的所有坏橘子
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                int[] tmp = deque.poll();
                for (int i = 0; i < dx.length; i++) {
                    int x = tmp[0] + dx[i];
                    int y = tmp[1] + dy[i];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y]!=1) continue;
                    deque.add(new int[]{x,y});
                    grid[x][y] = 2;
                }
                size--;
            }
            minute++;
        }
        return minute;
    }
}
