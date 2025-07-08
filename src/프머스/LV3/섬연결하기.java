package 프머스.LV3;

import java.util.*;
class 섬연결하기 {   // prim 알고리즘

    public int solution(int n, int[][] costs) {
        List<List<int[]>> adj = new ArrayList<>();
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] cost : costs){
            adj.get(cost[0]).add(new int[]{cost[2],cost[1]});
            adj.get(cost[1]).add(new int[]{cost[2],cost[0]});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.offer(new int[]{0,0});

        int totalCost = 0;
        int count = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[1];
            int cost = cur[0];

            if(visited[u]) continue;
            visited[u] = true;
            totalCost += cost;
            count++;
            if(count == n)break;

            for(int[] nxt : adj.get(u)){
                int v = nxt[1];
                int w = nxt[0];
                if(!visited[v]) pq.offer(new int[]{w,v});
            }

        }

        return totalCost;
    }


}
