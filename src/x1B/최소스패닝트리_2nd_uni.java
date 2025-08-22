package x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리_2nd_uni {
    static int N, M;
    static int[] p;
    static List<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        Arrays.fill(p, -1);



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new int[]{w, u, v});
        }

        edges.sort(Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        int ans = 0;

        for (int[] edge : edges) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(!uni(u,v)) continue; // 사이클 발생 시 스킵

            ans += cost;
            cnt++;
            if (cnt == N - 1) break;

        }
        System.out.println(ans);
    }

    static int find(int x) {
        if(p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    static boolean uni(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if (p[u] < p[v]) {
            p[v] = u;
        } else {
            p[u] = v;
        }
        return true;
    }
}
