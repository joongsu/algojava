package x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_2nd {
    static int V, E;
    static int start;
    static List<List<int[]>> adj = new ArrayList<>();
    static int[] d = new int[20008];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        Arrays.fill(d, 0, V + 1, Integer.MAX_VALUE);

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

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        d[start] = 0;
        pq.offer(new int[]{d[start], start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            for (int[] nxt : adj.get(cur[1])) {
                if(d[nxt[1]] <= d[cur[1]] + nxt[0]) continue;
                d[nxt[1]] = d[cur[1]] + nxt[0];
                pq.offer(new int[]{d[nxt[1]], nxt[1]});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(d[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else{
                sb.append(d[i]).append("\n");
            }
        }

        System.out.println(sb);

    }
}
