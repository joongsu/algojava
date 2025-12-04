package 프머스.LV3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기_union_find {
    int[] p;
    public int solution(int n, int[][] costs) {
        p = new int[n];
        Arrays.fill(p, -1);

        Arrays.sort(costs, Comparator.comparingInt(a->a[2]));

        int totalCnt = 0;
        int edgeCnt = 0;

        for(int[] edge : costs){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            // 사이클이 생기지 않으면 선택
            if (union(u, v)) {
                totalCnt += cost;
                edgeCnt++;

                // MST 완성 (정점 n개 → 간선 n-1개)
                if (edgeCnt == n - 1) break;
            }
        }

        return totalCnt;
    }

    int find(int x){
        if(p[x] < 0) return x; // 음수면 루트라는 의미
        return p[x] = find(p[x]);
    }

    boolean union(int u, int v){
        u = find(u);
        v = find(v);

        if (u == v) return false; // 이미 같은 집합 (사이클 발생)

        // Union by rank (크기 기반)
        if (p[u] < p[v]) {
            p[u] += p[v];
            p[v] = u;
        } else {
            p[v] += p[u];
            p[u] = v;
        }

        return true;
    }
}
