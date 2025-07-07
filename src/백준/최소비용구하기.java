package 백준; // 1916 - 최소비용 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기 {
    static int V, E;
    static int v1, v2;
    static List<List<int[]>> adj = new ArrayList<>();
    static int[] d = new int[1010];
    static int INF = 100000050;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        StringTokenizer st;

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
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int ans = dij(v1, v2);

        System.out.println(ans);
    }

    static int dij(int st, int ed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        Arrays.fill(d, INF);
        d[st] = 0;
        pq.offer(new int[]{d[st], st});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            for (int[] nxt : adj.get(cur[1])) {
                if(d[nxt[1]] > d[cur[1]] + nxt[0]){
                    d[nxt[1]] = d[cur[1]] + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }
        return d[ed];
    }
}
