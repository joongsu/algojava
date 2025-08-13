package x1D;    // 11779 - 최소비용 구하기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2_2nd {
    static int V, M;
    static List<List<int[]>> adj = new ArrayList<>();
    static int s, e;
    static int[] d = new int[1005];
    static int[] pre = new int[1005];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w, v});
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        Arrays.fill(d, 0, V + 1, INF);
        Arrays.fill(pre, 0, V + 1, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        d[s] = 0;
        pq.offer(new int[]{d[s], s});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            for (int[] nxt : adj.get(cur[1])) {
                if(d[nxt[1]] <= d[cur[1]] + nxt[0]) continue;
                d[nxt[1]] = d[cur[1]] + nxt[0];
                pq.offer(new int[]{d[nxt[1]], nxt[1]});
                pre[nxt[1]] = cur[1];
            }
        }

        sb.append(d[e]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(e);

        List<Integer> path = new ArrayList<>();
        int v = e;
        while (v != -1) {
            path.add(v);
            v = pre[v];
        }
        Collections.reverse(path);

        sb.append(path.size()).append("\n");

        for (int p : path) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);


    }
}
