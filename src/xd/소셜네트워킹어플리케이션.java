package xd; // 7511 - 소셜 네트워킹 어플리케이션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소셜네트워킹어플리케이션 {
    static int T, N, K, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {

            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            p = new int[N + 1];
            Arrays.fill(p, -1);

            int cnt = K;
            while (cnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                uni(u, v);
            }

            M = Integer.parseInt(br.readLine());

            sb.append("Scenario " + i + ":").append("\n");
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (find(u) == find(v)) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if(p[x] < 0)
            return x;
        return p[x] = find(p[x]);
    }

    static boolean uni(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if(p[u] == p[v])
            p[u]--;

        if (p[u] < p[v]) {
            p[v] = u;
        }else{
            p[u] = v;
        }

        return true;
    }

}
