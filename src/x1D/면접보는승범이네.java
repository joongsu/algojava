package x1D;    // 17835 - 면접보는 승범이네

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 면접보는승범이네 {
    static int V,E, K;
    static List<List<long[]>> adj = new ArrayList<>();
    static long[] d = new long[100005];
    static final long INF = Long.MAX_VALUE / 4;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(v).add(new long[]{w, u});
        }
        st = new StringTokenizer(br.readLine());
        Arrays.fill(d, 0, V + 1, INF);

        for (int i = 0; i < K; i++) {
            int s = Integer.parseInt(st.nextToken());
            d[s] = 0;
            pq.offer(new long[]{d[s], s});
        }
        dij();

        System.out.println(sb);
    }
    static void dij() {
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long dist = cur[0];
            int u = (int) cur[1];

            if(dist != d[u]) continue;

            for (long[] nxt : adj.get(u)) {
                int v = (int)nxt[1];

                if(d[v] <= d[u] + nxt[0]) continue;

                d[v] = d[u] + nxt[0];
                pq.offer(new long[]{d[v], nxt[1]});
            }
        }

        long max = 0;
        int idx = -1;

        for (int i = 1; i <= V; i++) {
            if (max < d[i] && d[i] != INF) {
                max = d[i];
                idx = i;
            }
        }

        for (int i = 1; i <= V; i++) {
            if (max == d[i] && i < idx) {
                idx = i;
            }
        }

        sb.append(idx).append("\n");
        sb.append(max);
    }
}
