package x18;    // 2660 - 회장뽑기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장뽑기 {
    static int v;
    static int k = Integer.MAX_VALUE;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] score;
    static int[] dist;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        score = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(u == -1 && v == -1) break;
            addEdge(u, v);
        }
        for (int i = 1; i <= v; i++) {
            bfs(i);
        }
        for (int i = 1; i <= v; i++) {
            if (score[i] == k) {
                pq.offer(i);
            }
        }
        System.out.println(k + " " + pq.size());

        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
    }

    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        dist = new int[v + 1];
        Arrays.fill(dist, 1, v+1, -1);

        q.offer(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i : adj.get(cur)) {
                if(dist[i] >= 0) continue;
                q.offer(i);
                dist[i] = dist[cur] + 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= v; i++) {
            if(dist[i] == -1) return;
            max = Math.max(max, dist[i]);
        }
        k = Math.min(k, max);
        score[s] = max;
    }


    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
