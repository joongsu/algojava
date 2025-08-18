package x19;    // 11725 - 트리의 부모 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_2nd {
    static int n;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] p = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            sb.append(p[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj.get(cur)) {
                if(p[cur] == nxt)continue; // 부모로 되돌아가는 간선 제외
                p[nxt] = cur;
                q.offer(nxt);
            }
        }
    }
    static void dfs(int cur) {
        for (int nxt : adj.get(cur)) {
            if(p[cur] == nxt) continue;
            /*  현재의 로직으로는 사이클 판단 불가
             * if(p[nxt] != 0) 이미 부모가 정해져 있다면
             *   isTree = false
             *   continue;
             * */
            p[nxt] = cur;
            dfs(nxt);
        }
    }
}
