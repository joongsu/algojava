package dfsbfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1260 - dfs와 bfs
public class dfsAndbfs {
    static int[][] graph;   // 빈칸 다 0으로 채워지나?
    static boolean[] visited; // 처음은 false 로 되어있음
    public static void main(String[] args) throws IOException {
        //첫째줄에 정점의 개수 N , 간선의 개수 M , 시작 정점 V

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());  // 5
        int M = Integer.parseInt(st.nextToken());  // 5
        int V = Integer.parseInt(st.nextToken());  // 3

        graph = new int[N + 1][N + 1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 1 ; i < graph.length ; i++){
            if(graph[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 1; i < graph.length ; i++){
                if(graph[cur][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
