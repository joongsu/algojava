package x1D;    // 10282 - 해킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹 {
    static int T;
    static int V, E, C;
    static StringBuilder sb = new StringBuilder();
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            List<List<int[]>> adj = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                // u -> v (u가 v를 의존한다. v 감염시 u가 s초 후 감염)
                // u -> c 인 애들

                adj.get(v).add(new int[]{s, u});
            }

            dij(adj);
        }

        System.out.println(sb);
    }

    static void dij(List<List<int[]>> adj) {
        int[] d = new int[V + 1];

        Arrays.fill(d, 1, V + 1, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        d[C] = 0;
        pq.offer(new int[]{d[C], C});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cw = cur[0];

            if(d[cx] != cw) continue;

            for (int[] nxt : adj.get(cx)) {

                if (d[nxt[1]] > cw + nxt[0]) {
                    d[nxt[1]] = cw + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }

        int max = 0;
        int cnt = 0;

        for (int i = 1; i <= V; i++) {
            if (d[i] < INF) {
                cnt++;
                max = Math.max(max, d[i]);
            }
        }

        sb.append(cnt).append(" ").append(max);
        sb.append("\n");
    }
}
