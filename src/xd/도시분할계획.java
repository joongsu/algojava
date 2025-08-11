package xd; // 1647 - 도시 분할 게획

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static int N, M;
    static PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    static int[] p;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        Arrays.fill(p, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Road(from, to, cost));
        }

        System.out.println(solve());
    }

    static int solve() {
        int size = 0;
        int ans = 0;

        while (!pq.isEmpty()) {
            if(size >= N-2) break;

            Road road = pq.poll();

            if (uni(road.from, road.to)) {
                ans += road.cost;
                size++;
            }
        }

        return ans;
    }

    static class Road{
        int from;
        int to;
        int cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int find(int x) {
        if(p[x] < 0)
            return x;
        return p[x] = find(p[x]);
    }

    static boolean uni(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if(p[u] == p[v]) p[u]--;

        if (p[u] < p[v]) {
            p[v] = u;
        }else{
            p[u] = v;
        }

        return true;
    }
}
