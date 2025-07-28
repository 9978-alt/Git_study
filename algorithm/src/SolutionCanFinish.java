import java.util.*;

public class SolutionCanFinish {
    // 广度优先搜索
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer,List<Integer>> pre = new HashMap<>();
//        Map<Integer,Integer> degree = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            int course = prerequisites[i][0];
//            int precourse = prerequisites[i][1];
//            degree.put(precourse,degree.getOrDefault(precourse,0)+1);// 入度+1
//            List<Integer> preList = pre.getOrDefault(course,new ArrayList<>());
//            preList.add(precourse);
//            pre.put(course,preList);
//        }
//
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if(!degree.containsKey(i)){
//                deque.add(i);
//            }
//        }
//
//        int count = 0;
//        while (!deque.isEmpty()){
//            int course = deque.poll();
//            count++;
//            List<Integer> list = pre.get(course);
//            for (int i = 0;list!=null && i < list.size(); i++) {
//                Integer ru = degree.getOrDefault(list.get(i), 0);
//                ru--;
//                if(ru == 0) deque.add(list.get(i));
//                if(ru>=0) degree.put(list.get(i),ru);
//            }
//        }
//    return  count == numCourses;
//    }

    List<List<Integer>> edges;
    int[] visited;
    boolean valid;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {  // 初始化边
            edges.set(i,new ArrayList<>());
        }
        visited = new int[numCourses];
        valid = true;
        for (int[] info : prerequisites){
            int course = info[0];
            int precourse = info[1];
            List<Integer> list = edges.get(course);
            list.add(precourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) dfs(i);
        }
        return valid;
    }

    private void dfs(int u){
        visited[u] = 1; //将节点状态改为搜索中
        List<Integer> integers = edges.get(u);
        for (int i = 0; i < integers.size(); i++) {
            if(visited[integers.get(i)] == 0){
                dfs(integers.get(i));
                if(!valid) return ;
            } else if (visited[integers.get(i)] == 1) {
                valid = false;
                return;
            }
        }
        visited[u]=2;
    }


}



