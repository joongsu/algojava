package 백준.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미확인도착지_2nd { // 14:46
    static int T;
    static int n,m,t;
    static int s,g, h;
    static List<List<int[]>> adj;
    static final int INF = 2000000;

    public static void main(String[] args) throws IOException {
        // n m t -> 교차로, 도로, 목적지 후보
        // s g h -> 출발지, g h (반드시 지나는 곳)
        // a b d -> a b d(길이)
        // 목적지 후보들

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                adj.add(new ArrayList<>());
            }
            List<Integer> dest = new ArrayList<>();
            int wgh = 0;

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adj.get(u).add(new int[]{w, v});
                adj.get(v).add(new int[]{w, u});

                if((g == u && h == v) || (g == v && h == u)) wgh = w;
            }

            for (int j = 0; j < t; j++) {
                dest.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(dest);

            // s->g->h->x
            // s->h->g->x
            int[] distS = dij(s);
            int[] distG = dij(g);
            int[] distH = dij(h);
            List<Integer> ans = new ArrayList<>();

            for (int x : dest) {
                long path1 = (long) distS[g] + wgh + distH[x];
                long path2 = (long) distS[h] + wgh + distG[x];

                if(path1 == distS[x] || path2 == distS[x]) ans.add(x);
            }

            Collections.sort(ans);
            for (int x : ans) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dij(int start) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);

        d[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[start], start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cw = cur[0];

            if(cw != d[cx]) continue;

            for (int[] nxt : adj.get(cx)) {
                if (d[nxt[1]] > cw + nxt[0]) {
                    d[nxt[1]] = cw + nxt[0];
                    pq.offer(new int[]{d[nxt[1]], nxt[1]});
                }
            }
        }

        return d;
    }
}
