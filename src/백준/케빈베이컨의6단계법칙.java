package 백준; // 1389 - 케빈 베이컨의 6단계 법칙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 케빈베이컨의6단계법칙 {

    static int V, E;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[][] d = new int[105][105];


    public static void main(String[] args) throws IOException {
        // 케빈 베이컨 = 게임 했을 때 나오는 단계의 총 합이 가장 적은 사람이다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }

        for (int i = 1; i <= V; i++) {
            bfs(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparing((int[] a) -> a[0])
                        .thenComparing(a -> a[1])
        );

        for (int i = 1; i <= V; i++) {
            int sum = 0;
            for (int j = 1; j <= V; j++) {
                sum += d[i][j];
            }

            pq.offer(new int[]{sum, i});
        }

        int[] s = pq.poll();
        System.out.println(s[1]);

    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];

        q.offer(start);
        visited[start] = true;
        d[start][start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    d[start][nxt] = d[start][cur] + 1;
                    q.offer(nxt);
                }
            }
        }
    }

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
