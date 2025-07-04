package x1C;    // 11404 - 플로이드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {
    static int[][] d = new int[105][105];
    static final int INF = 100 * 100000;
    static int V,E;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= V; i++) {
            Arrays.fill(d[i], 1, V + 1, INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            d[v][u] = Math.min(d[v][u], k);
        }
        for (int i = 1; i <= V; i++) d[i][i] = 0;

        for (int k = 1; k <= V; k++) {
            for (int s = 1; s <= V; s++) {
                for (int t = 1; t <= V; t++) {
                    d[s][t] = Math.min(d[s][t], d[s][k] + d[k][t]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(d[i][j] == INF) sb.append("0 ");
                else sb.append(d[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
