package 백준.그래프; // 2644 - 촌수계산


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {
    static int N, M;
    static int s, e;
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] vis = new boolean[105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(dfs(s, 0));

    }

    static int dfs(int v, int depth) {
        if (v == e) {
            return depth;
        }
        vis[v] = true;

        for (int nxt : adj.get(v)) {
            if (!vis[nxt]) {
                int ret = dfs(nxt, depth + 1);
                if(ret != -1) return ret;
            }
        }
        return -1;
    }
}
