package 프머스.알고리즘고득점kit.그래프;

import java.util.*;
class 가장먼노드 {
    static List<List<Integer>> adj = new ArrayList<>();
    static int V;
    static int[] d;
    static int max, ans;

    public int solution(int n, int[][] edge) {
        d = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] k : edge){
            int u = k[0];
            int v = k[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visit = new boolean[n+1];
        visit[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nxt : adj.get(cur)){
                if(visit[nxt])continue;
                visit[nxt] = true;
                d[nxt] = d[cur] + 1;
                max = Math.max(max , d[nxt]);
                q.offer(nxt);
            }
        }
        for(int i : d){
            if(i == max){
                ans++;
            }
        }

        return ans;
    }
}
