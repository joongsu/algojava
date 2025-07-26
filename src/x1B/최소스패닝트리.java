package x1B;    // 1197 - 최소 스패닝 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리 {
    static int v, e;
    static List<List<int[]>> adj = new ArrayList<>();
    static boolean[] chk = new boolean[10005];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            addEdge(a, b, cost);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        chk[1] = true;
        for (int[] nxt : adj.get(1)) {
            pq.offer(new int[]{nxt[0], 1, nxt[1]});
        }
        int ans = 0;


        while (cnt < v - 1) {
            int[] cur = pq.poll();

            int cost = cur[0];
            int a = cur[1];
            int b = cur[2];

            if(chk[b]) continue;

            chk[b] = true;
            cnt++;
            ans += cost;

            for (int[] nxt : adj.get(b)) {
                if (!chk[nxt[1]]) {
                    pq.offer(new int[]{nxt[0], b, nxt[1]});
                }
            }
        }
        System.out.println(ans);
    }

    static void addEdge(int u, int v, int cost) {
        adj.get(u).add(new int[]{cost, v});
        adj.get(v).add(new int[]{cost, u});
    }
}
