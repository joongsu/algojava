package 연습.다익스트라; // 20168 - 골목 대장 호석 - 기능성

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 골목대장호석 {
    static int N, M, A, B, C;
    static List<List<int[]>> adj = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;

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

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            max = Math.max(max, c);

            adj.get(u).add(new int[]{c, v});
            adj.get(v).add(new int[]{c, u});
        }


        int lw = 1;
        int hi = max;
        int ans = -1;


        while (lw <= hi) {
            int mid = (lw + hi) / 2;

            if (isCheck(mid)) {
                ans = mid;
                hi = mid - 1;
            }else{
                lw = mid + 1;
            }
        }


        System.out.println(ans);

    }

    static boolean isCheck(int x) {
        // x원 이하의 간선들로 갈 수 있는가?

        int[] d = new int[N + 1];
        Arrays.fill(d, 1, N + 1, INF);

        d[A] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[A], A});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cv = cur[0];

            if(cv != d[cx]) continue;

            for (int[] nxt : adj.get(cx)) {
                int nx = nxt[1];
                int nv = nxt[0];
                if(nv > x) continue; // x원을 넘어서는 비용인 간선은 제외

                if (d[cx] + nv < d[nx]) {
                    d[nx] = d[cx] + nv;
                    pq.offer(new int[]{d[nx], nx});
                }
            }
        }


        return d[B] <= C;
    }
}
