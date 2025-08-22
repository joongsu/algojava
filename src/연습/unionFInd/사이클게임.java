package 연습.unionFInd;   // 20040 - 사이클 게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사이클게임 {

    static int[] p;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N];
        Arrays.fill(p, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!uni(u, v)) { // u,v 연결하기 전에 부모가 같으면 사이클 발생
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }

    static int find(int x) {

        if(p[x] < 0)
            return x;
        return p[x] = find(p[x]);
    }

    static boolean uni(int u, int v) {

        u = find(u);
        v = find(v);

        if (u == v) {
            return false;
        }

        if(p[u] == p[v]) p[u]--;

        if (p[u] < p[v]) {
            p[v] = u;
        } else {
            p[u] = v;
        }
        return true;

    }
}
