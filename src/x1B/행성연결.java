package x1B;    // 16398 - 행성 연결

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 행성연결 {
    static int n;
    static List<List<int[]>> adj = new ArrayList<>();
    static boolean[] chk = new boolean[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                adj.get(i).add(new int[]{cost, j});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] nxt : adj.get(1)) {
            pq.offer(new int[]{nxt[0], 1, nxt[1]});
        }

        int cnt = 0;
        long ans = 0;
        chk[1] = true;

        while (cnt < n - 1) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];
            int v = cur[2];

            if(chk[v]) continue; // 1->2 , 1->3

            cnt++;
            chk[v] = true; // 1->2 선택
            ans += (long) cost;

            for (int[] nxt : adj.get(v)) {
                if (!chk[nxt[1]]) {
                    pq.offer(new int[]{nxt[0], v, nxt[1]});
                }
            }
        }

        System.out.println(ans);
    }
}
