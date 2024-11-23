package dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 백준 - 11724 연결요소의 개수
public class linkcount {

    static boolean[] visited;
    static List<Set<Integer>> graph = new ArrayList<>();
    static int M, N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>()); // 정점 수 만큼 hashSet 생성
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int v){
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int node : graph.get(cur)){
                if(!visited[node]){
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
    }
}
