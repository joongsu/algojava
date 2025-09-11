package x1D;    // 20183 - 골목 대장 호석 - 효율성 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 골목대장호석효율성2 {
    static int N, M, A, B;
    static long C;
    static List<List<int[]>> adj = new ArrayList<>();
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        //풀이 : "X 이하의 간선만 사용해서 A -> B 갈 수 있는가? 그리고 총합 <= C 인가? 를 체크
        // 이분 탐색 O(log(maxEdge)) x 다익스트라 O(M log N)

        int maxEdge = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxEdge = Math.max(maxEdge, c);
            addEdge(u, v, c);
        }

        int lo = 1, hi = maxEdge, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(check(mid)){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean check(int limit) {

        long[] d = new long[N + 1];
        Arrays.fill(d, 1, N + 1, INF);
        d[A] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

        pq.offer(new long[]{d[A], A});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            long dist = cur[0];
            int u = (int)cur[1];

            if(dist != d[u]) continue;

            for (int[] nxt : adj.get(u)) {
                int v = (int) nxt[1];
                if(nxt[0] > limit) continue;

                if (d[u] + nxt[0] < d[v]) {
                    d[v] = d[u] + nxt[0];
                    pq.offer(new long[]{d[v], v});
                }
            }
        }
        return d[B] <= C;
    }

    static void addEdge(int u, int v, int w) {
        adj.get(u).add(new int[]{w, v});
        adj.get(v).add(new int[]{w, u});
    }
}
