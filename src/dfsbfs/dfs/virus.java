package dfsbfs.dfs;

import java.util.*;


public class virus {
    /*static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n,m;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        // 정점 100 이하, 둘째줄 간선 .
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i<=n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[n+1];
        bfs(1);
        System.out.println(result.size());
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            ArrayList<Integer> curList = graph.get(cur);
            int size = graph.get(cur).size();
            for(int i = 0; i< size; i++){
                for(int next : curList){
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                        result.add(next);
                    }
                }
            }
        }
    }*/
    static List<Set<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
    }
    public static void dfs(int v) {
        visited[v] = true;
        for (int node : graph.get(v)) {
            System.out.println("graph = " + graph.get(v));
            if (!visited[node]) {
                dfs(node);
            }
        }

    }
}
