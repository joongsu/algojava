package x19;    // 4803 - 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
    static int n, m, trees, tc;
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] vis = new boolean[510];
    static boolean isTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;
            // 1-> 2 -> 3 -> 4

            adj.clear();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            Arrays.fill(vis, 0, n + 1, false);

            trees = 0;

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            for (int i = 1; i <= n; i++) {
                if(vis[i]) continue;
                vis[i] = true;
                isTree = true;
                dfs(i,-1);
                if(isTree) trees++;
            }
            System.out.print("Case " + ++tc +": ");
            if (trees < 1) {
                System.out.print("No trees.");
            } else if (trees == 1) {
                System.out.print("There is one tree.");
            }else{
                System.out.print("A forest of " + trees + " trees.");
            }
            System.out.println();
        }
    }

    static void dfs(int cur, int prev) {
        for (int nxt : adj.get(cur)) {
            if(nxt == prev) continue; // nxt가 부모일경우 건너뜀

            if(vis[nxt]){ // 트리일 경우 자식은 반드시 이전에 방문한 적이 없어야 하고, 이전에
                // 방문 했다면 현재 보고 있는 connected component가 트리가 아님을 의미
                isTree = false;
                return;
            }
            vis[nxt] = true;
            dfs(nxt, cur);
        }
    }
}
