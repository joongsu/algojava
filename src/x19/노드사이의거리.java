package x19; // 1240 - 노드사이의 거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의거리 {
    static int V, M;
    static List<List<int[]>> adj = new ArrayList<>();

    static boolean[] vis;
    static int ans;

    static int s, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
            adj.get(v).add(new int[]{w, u});
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            vis = new boolean[V + 1];
            dfs(s, 0);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int cur, int dist) {
        if(vis[cur]) return;

        vis[cur] = true;
        if (cur == e) {
            ans = dist;
        }

        for (int[] nxt : adj.get(cur)) {
            dfs(nxt[1], dist + nxt[0]);
        }
    }
}
