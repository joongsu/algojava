package x1D;    // 1238 - 파티

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    static List<List<int[]>> adj = new ArrayList<>();
    static int V, E, X;
    static int INF = 100010;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{k,v});
        }

        for (int i = 1; i <= V; i++) {
            max = Math.max(max, dij(i, X) + dij(X, i));
        }
        System.out.println(max);
    }

    static int dij(int s, int e) {
        int[] d = new int[1005];
        Arrays.fill(d, 1, V + 1, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        d[s] = 0;
        pq.offer(new int[]{d[s], s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            for (int[] nxt : adj.get(cur[1])) {
                if(d[nxt[1]] <= d[cur[1]] + nxt[0]) continue;
                d[nxt[1]] = d[cur[1]] + nxt[0];
                pq.offer(new int[]{d[nxt[1]], nxt[1]});
            }
        }
        return d[e];
    }
}
