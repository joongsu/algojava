package x1D;    // 1753 - 최단경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    static int E, V;
    static List<List<Node>> adj = new ArrayList<>();
    static int start;
    static int[] d = new int[20005];

    static class Node{
        int weight, end;

        Node(int w, int e) {
            this.weight = w;
            this.end = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        Arrays.fill(d, 0, V + 1, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Node(w, v));
        }
        // 배열의 0번째 원소를 기준으로 오름차순 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.weight));

        d[start] = 0;
        pq.offer(new Node(d[start], start));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            // 값 불일치는 필요없는 값이라는 것
            if(cur.weight != d[cur.end]) continue;
            for (Node nxt: adj.get(cur.end)) {
                //d[cur.end] + nxt.weight = 시작점에서 cur 까지 오는데 최단 거리 + cur -> nxt 거리
                if(d[nxt.end] <= d[cur.end] + nxt.weight) continue;
                d[nxt.end] = d[cur.end] + nxt.weight;
                pq.offer(new Node(d[nxt.end], nxt.end));
            }
        }

        for (int i = 1; i <= V; i++) {
            if(d[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(d[i]).append("\n");
        }
        System.out.println(sb);
    }
}
