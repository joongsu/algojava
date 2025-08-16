package x1D;    // 14938 - 서강그라운드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서강그라운드 {
    static int V, E, M; // M -> 수색범위
    static int[] items = new int[105];
    static List<List<int[]>> adj = new ArrayList<>();
    static final int INF = 4000;

    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= V; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            adj.add(new ArrayList<>());
        }
        adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            addEdge(u, v, w);
        }

        for (int i = 1; i <= V; i++) {
            dij(i);
        }


        System.out.println(max);
    }

    static void dij(int s) {
        int[] d = new int[V + 1];
        Arrays.fill(d, 1, V + 1, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        d[s] = 0;
        pq.offer(new int[]{d[s], s});


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cw = cur[0];
            int cx = cur[1];

            if(d[cx] != cw) continue;

            for (int[] nxt : adj.get(cx)) {
                if (d[nxt[1]] > d[cx] + nxt[0]) {
                    d[nxt[1]] = d[cx] + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }


        int k = 0;
        for (int i = 1; i <= V; i++) {
            if (d[i] != INF && d[i] <= M) {
                k += items[i];
            }
        }


        max = Math.max(max, k);
    }

    static void addEdge(int u, int v, int w) {
        adj.get(u).add(new int[]{w, v});
        adj.get(v).add(new int[]{w, u});
    }
}