package 프머스.LV2.완전탐색;

import java.util.*;

class 전력망을둘로나누기 {
    static int min = Integer.MAX_VALUE;
    static boolean[] vis;

    public int solution(int n, int[][] wires) {

        int length = wires.length;
        for(int i = 0 ; i < length ; i++){
            List<List<Integer>> adj = new ArrayList<>();

            for(int j = 0 ; j <= n ; j++){
                adj.add(new ArrayList<>());
            }

            for(int j = 0 ; j < length; j++){
                if(i == j) continue; // 특정 간선 제외
                int u = wires[j][0];
                int v = wires[j][1];

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            vis = new boolean[n+1];
            int cnt = bfs(adj); // 송전탑 개수
            int dif = Math.abs(cnt - (n - cnt));


            min = Math.min(min, dif);
        }
        return min;

    }

    static int bfs(List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        vis[1] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nxt :adj.get(cur)){
                if(!vis[nxt]){
                    vis[nxt] = true;
                    q.offer(nxt);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}