package x1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시분할계획_2nd {
    static List<int[]> edges = new ArrayList<>();
    static int max;
    static int N, M;
    static int[] p;
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

        int ans = 0;

        for (int[] edge : edges) {
            int w = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(!uni(u,v)) continue;
            max = Math.max(max, w);
            ans += w;
        }
        System.out.println(ans - max);
    }

    static int find(int x) {
        if(p[x] < 0 )
            return x;
        return p[x] = find(p[x]);
    }

    static boolean uni(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if(p[u] == p[v]) p[u]--;

        if (p[u] < p[v]) {
            p[v] = u;
        }else{
            p[u] = v;
        }

        return true;
    }
}
