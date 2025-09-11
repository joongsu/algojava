package x1D;    // 20182 - 골목 대장 호석 - 효율성 1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 골목대장호석효율성1 {
    static int N,M,A,B, C;
    static List<List<int[]>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int maxEdge = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            maxEdge = Math.max(maxEdge, w);
            adj.get(u).add(new int[]{w, v});
            adj.get(v).add(new int[]{w, u});
        }

        int lo = 1, hi = maxEdge, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) {
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean check(int limit) {
        int[] d = new int[N + 1];
        Arrays.fill(d, 1, N + 1, Integer.MAX_VALUE);
        d[A] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[A], A});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int u = cur[1];

            if(dist != d[u]) continue;

            for (int[] nxt : adj.get(u)) {
                int v = nxt[1];
                int w = nxt[0];
                if(w > limit) continue;

                if (d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                    pq.offer(new int[]{d[v], v});
                }
            }
        }

        return d[B] <= C;
    }
}
