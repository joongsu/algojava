package x1C;    // 11780 - 플로이드 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 플로이드2 {
    static int[][] d = new int[105][105];
    static int V, E;
    static int[][] nxt = new int[105][105];
    static final int INF = 100 * 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            Arrays.fill(d[i], 1, V + 1, INF);
        }
        StringTokenizer st;
        //nxt[u][v] -> u 에서 v까지 최단거리로 가려면 u에서 어느 정점으로 가야 하는지를 나타냄
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            d[u][v] = Math.min(d[u][v], k);
            nxt[u][v] = v;
        }
        for(int i = 1 ; i <= V ; i++) d[i][i] = 0;

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                        nxt[i][j] = nxt[i][k];
                    }
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


        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(d[i][j] == 0 || d[i][j] == INF){
                    sb.append("0").append("\n");
                    continue;
                }
                List<Integer> path = new ArrayList<>();
                int cur = i;

                while (cur != j) {
                    path.add(cur);
                    cur = nxt[cur][j];
                }
                path.add(j);
                sb.append(path.size()).append(" ");
                for(int k : path) sb.append(k).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);



    }
}
