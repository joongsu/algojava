package x1D;    // 파티 - 1238 (역방향)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티3rd {
    static int V, E, X;
    static List<List<int[]>> adj = new ArrayList<>();
    static List<List<int[]>> adjRev = new ArrayList<>();
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
            adjRev.get(v).add(new int[]{w, u});
        }

        int[] distFromX = dij(adj, X);
        int[] distToX = dij(adjRev, X);

        int ans = 0;
        for (int i = 1; i <= V; i++) {
            if (distToX[i] != INF && distFromX[i] != INF) {
                ans = Math.max(ans, distToX[i] + distFromX[i]);
            }
        }
        System.out.println(ans);
    }

    static int[] dij(List<List<int[]>> graph, int start) {
        int[] d = new int[V + 1];
        Arrays.fill(d, INF);

        d[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[start], start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cw = cur[0];

            if(cw != d[cx]) continue;

            for (int[] nxt : graph.get(cx)) {
                int nx = nxt[1];
                int nw = nxt[0];
                if (nw + d[cx] < d[nx]) {
                    d[nx] = nw + d[cx];
                    pq.offer(new int[]{d[nx], nx});
                }
            }
        }
        return d;
    }
}
