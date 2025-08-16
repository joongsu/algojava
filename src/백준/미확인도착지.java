package 백준; // 9370 - 미확인도착지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미확인도착지 {
    static int T;
    static int n, m, t;
    static int s, g, h, wgh;
    static List<Integer> dest;
    static final int INF = 1000000000;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

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


            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adj.get(u).add(new int[]{w, v});
                adj.get(v).add(new int[]{w, u});

                if((g == u & h == v) || (g== v && h == u)) wgh = w;
            }
            dest = new ArrayList<>();

            for (int j = 0; j < t; j++) {
                int d = Integer.parseInt(br.readLine());
                dest.add(d);
            }
            Collections.sort(dest);

            int[] distS = dij(s);
            int[] distG = dij(g);
            int[] distH = dij(h);

            List<Integer> ans = new ArrayList<>();
            for (int x : dest) {
                long path1 = (long) distS[g] + wgh + distH[x]; // s->g->h->x
                long path2 = (long) distS[h] + wgh + distG[x]; // s->h->g->x
                if(path1 == distS[x] || path2 == distS[x]) ans.add(x);
            }
            Collections.sort(ans);

            for(int x : ans) sb.append(x).append(" ");
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
            int cw = cur[0];
            int cx = cur[1];

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
