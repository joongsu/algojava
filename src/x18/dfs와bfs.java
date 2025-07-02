package x18;    // 1260 - dfs와 bfs (graph)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs와bfs {
    static List<List<Integer>> adj = new ArrayList<>();
    static int v,e, s;
    static boolean[] visit = new boolean[1005];

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (List<Integer> a : adj) {
            Collections.sort(a);
        }
        dfs(s);
        sb.append("\n");

        bfs();

        System.out.println(sb);
    }

    static void dfs(int cur) {
        visit[cur] = true;
        sb.append(cur).append(" ");
        for (int i : adj.get(cur)) {
            if(visit[i]) continue;
            dfs(i);
        }
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visit, 0, v + 5, false);
        q.offer(s);
        visit[s] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i : adj.get(cur)) {
                if(visit[i]) continue;
                visit[i] = true;
                q.offer(i);
            }
        }
    }


    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
