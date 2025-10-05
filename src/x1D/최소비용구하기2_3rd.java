package x1D;    // 11779 - 최소비용 구하기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2_3rd {
    static int V, E;
    static List<List<int[]>> adj = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static int[] pre;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dij(start, end);
        sb.append(d[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        int k = end;

        while (k != -1) {
            stack.push(k);
            k = pre[k];
        }
        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
    static void dij(int s, int e) {
        d = new int[V + 1];
        Arrays.fill(d, INF);
        d[s] = 0;

        pre = new int[V + 1];
        Arrays.fill(pre, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[s], s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cw = cur[0];
            int cx = cur[1];

            if(d[cx] != cw) continue;
            if (cx == e) {
                break;
            }

            for (int[] nxt : adj.get(cx)) {
                int nw = nxt[0];
                int nx = nxt[1];

                if (nw + d[cx] < d[nx]) {
                    d[nx] = nw + d[cx];

                    pre[nx] = cx;
                    pq.offer(new int[]{d[nx], nx});
                }
            }
        }
    }
}
