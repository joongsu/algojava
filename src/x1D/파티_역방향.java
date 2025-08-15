package x1D;    // 1238 - 파티 (역방향 풀이)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_역방향 {
    static int V, E, X;
    static List<List<int[]>> adjRev = new ArrayList<>();
    static List<List<int[]>> adj = new ArrayList<>();
    static final int INF = 1000009;

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

            adj.get(u).add(new int[]{w, v}); //
            adjRev.get(v).add(new int[]{w, u}); // X -> V(다수로) i에서의 시작했을떄 최소를 구하는거
        }

        int[] distFromX = dij(adj, X);  // X -> i
        int[] distToX = dij(adjRev, X); // i -> X (역그래프에서)

        int ans = 0 ;

        for (int i = 1; i <= V; i++) {
            if (distToX[i] < INF && distFromX[i] < INF) {
                ans = Math.max(ans, distToX[i] + distFromX[i]);
            }
        }

        System.out.println(ans);
    }

    static int[] dij(List<List<int[]>> graph, int start) {
        int[] d = new int[V + 1];
        Arrays.fill(d, 1, V + 1, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        d[start] = 0;
        pq.offer(new int[]{d[start], start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cw = cur[0];

            if(cw != d[cx]) continue;

            for (int[] nxt : graph.get(cx)) {
                if (d[nxt[1]] > cw + nxt[0]) {
                    d[nxt[1]] = cw + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }
        return d;
    }
}
