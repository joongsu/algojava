package 연습.unionFInd;   // 1976 - 여행 가자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여행가자 {
    static int[][] graph = new int[205][205];
    static int N, M;
    static int[] p = new int[205];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Arrays.fill(p, -1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    uni(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        int root = find(route[0]);

        for (int i = 1; i < M; i++) {
            if (find(route[i]) != root) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
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

        if(p[u] == p[v]) p[u]--;

        if (p[u] < p[v]) {
            p[v] = u;
        }else{
            p[u] = v;
        }
        return true;
    }
}
