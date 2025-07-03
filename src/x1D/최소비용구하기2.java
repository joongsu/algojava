package x1D;    // 11779 - 최소비용 구하기 2


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.util.*;


public class 최소비용구하기2 {
    static int V, E;
    static List<List<int[]>> adj = new ArrayList<>();
    static int start, dest;
    static int[] d = new int[1005];
    static int[] pre = new int[1005];
    static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{w,v});
        }
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        Arrays.fill(d, 0, V +1, INF);
        d[start] = 0;
        pq.add(new int[]{d[start],start});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(d[cur[1]] != cur[0]) continue;

            for(int[] nxt : adj.get(cur[1])){
                if(d[nxt[1]] <= d[cur[1]] + nxt[0]) continue;
                d[nxt[1]] = d[cur[1]] + nxt[0];
                pq.offer(new int[]{d[nxt[1]],nxt[1]});
                pre[nxt[1]] = cur[1];
            }
        }

        sb.append(d[dest]).append("\n");
        List<Integer> path = new ArrayList<>();

        int cur = dest;

        while(cur != start){
            path.add(cur);
            cur = pre[cur];
        }
        path.add(cur);

        Collections.reverse(path);

        sb.append(path.size()).append("\n");

        for(int i : path){
            sb.append(i).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);

    }
}
