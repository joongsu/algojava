package x1B; // 1647 - 도시 분할 계획

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시분할계획 {
    static int V, E;
    static List<List<int[]>> adj = new ArrayList<>();
    static boolean[] chk = new boolean[100005];

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
            int cost = Integer.parseInt(st.nextToken());

            addEdge(u, v, cost);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] nxt : adj.get(1)) {
            pq.offer(new int[]{nxt[0], 1, nxt[1]});
        }
        chk[1] = true;
        int cnt = 0;
        int max = -1;
        int ans = 0;

        while (cnt < V - 1) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];
            int v = cur[2];

            if(chk[v]) continue;
            chk[v] = true;
            cnt++;
            max = Math.max(max, cost);
            ans += cost;

            for (int[] nxt : adj.get(v)) {
                if (!chk[nxt[1]]) {
                    pq.offer(new int[]{nxt[0], v, nxt[1]});
                }
            }
        }
        System.out.println(ans - max);
    }

    static void addEdge(int u, int v, int cost) {
        adj.get(u).add(new int[]{cost, v});
        adj.get(v).add(new int[]{cost, u});
    }
}
