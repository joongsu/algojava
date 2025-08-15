package x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티2nd {
    static int V, E, X;
    static List<List<int[]>> adj = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static final int INF = 1000009;

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
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
        }

        for (int i = 1; i <= V; i++) {
            max = Math.max(max, dij(i, X) + dij(X, i));
        }

        System.out.println(max);
    }

    static int dij(int s, int e) {
        int[] d = new int[V + 1];
        Arrays.fill(d, 0, V + 1, INF);


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        d[s] = 0;

        pq.offer(new int[]{d[s], s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cw = cur[0];

            if(cw != d[cx]) continue;

            for (int[] nxt : adj.get(cx)) {
                if (d[nxt[1]] > cw + nxt[0]) {
                    d[nxt[1]] = cw + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }

        return d[e];
    }
}
