package x1D;    // 1753 - 최단경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_3rd {
    static int V, E;
    static List<List<int[]>> adj = new ArrayList<>();
    static int s, e;
    static int[] d;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        s = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
        }
        dij();

        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(d[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dij() {
        d = new int[V + 1];
        Arrays.fill(d, 1, V + 1, INF);
        d[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[s], s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cw = cur[0];
            int cx = cur[1];

            if(cw != d[cx]) continue;

            for (int[] nxt : adj.get(cx)) {
                int nw = nxt[0];
                int nx = nxt[1];

                if (d[cx] + nw < d[nx]) {
                    d[nx] = d[cx] + nw;

                    pq.offer(new int[]{d[nx], nx});
                }
            }
        }
    }
}
