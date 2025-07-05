package x1D;    // 1504 - 특정한 최단 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단경로 {
    static List<List<int[]>> adj = new ArrayList<>();
    static int V, E;
    static int v1, v2;
    static int[] d = new int[820];
    static int INF = 1700000;   // 1 - 2(v1) - 799(v2) - 800
                                // 최악의 경우 v1-v2 사이 왕복 고려
                                // 최대 : 2000 + (798-1) * 1000 * 2 = 1596000

    public static void main(String[] args) throws IOException {
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
            int w = Integer.parseInt(st.nextToken());
            addEdge(u, v, w);
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        int ans1 = dij(1, v1) + dij(v1, v2) + dij(v2, V);
        int ans2 = dij(1, v2) + dij(v2, v1) + dij(v1, V);
        int ans = Math.min(ans1, ans2);
        if(ans >= INF) ans = -1;
        System.out.println(ans);
    }

    static int dij(int st, int ed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        Arrays.fill(d, 0, V + 1, INF);
        d[st] = 0;
        pq.offer(new int[]{d[st], st});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            // 현재 위치한 정점과 연결된 곳
            for (int[] nxt : adj.get(cur[1])) {
                if (d[nxt[1]] > d[cur[1]] + nxt[0]) {
                    d[nxt[1]] = d[cur[1]] + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }
        return d[ed];
    }

    static void addEdge(int u, int v, int w) {
        adj.get(u).add(new int[]{w, v});
        adj.get(v).add(new int[]{w, u});
    }
}
