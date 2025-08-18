package x19;    // 15681 - 트리와 쿼리


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리와쿼리 {
    static int N,R, Q;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] p;
    static int[] size;
    static List<Integer> order = new ArrayList<>();
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        p = new int[N + 1];

        vis = new boolean[N + 1];

        size = new int[N + 1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        p[R] = 0;
        vis[R] = true;
        bfs(R);

        for (int i = order.size() - 1; i >= 0; i--) {
            int u = order.get(i);
            if(p[u] != 0) size[p[u]] += size[u];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(size[x]).append("\n");
        }

        System.out.println(sb);

    }

    static void bfs (int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cur = q.poll();

            order.add(cur);
            for (int nxt : adj.get(cur)) {
                if(vis[nxt]) continue;
                vis[nxt] = true;
                p[nxt] = cur;
                q.offer(nxt);
            }
        }
    }
}
