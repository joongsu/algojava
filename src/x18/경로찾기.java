package x18;    // 11403 - 경로찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 경로찾기 {
    static int v;
    static int[][] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        graph = new int[v][v];
        visit = new boolean[v];

        StringTokenizer st;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < v; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(dfs(i, j) + " ");
            }
            System.out.println();
        }

    }

    static int dfs(int st, int tar) {
        Arrays.fill(visit, 0, v, false);
        Stack<Integer> stk = new Stack<>();
        stk.push(st);

        while (!stk.isEmpty()) {
            int cur = stk.pop();

            if(visit[cur]) continue;
            if(cur != st) visit[cur] = true;

            for (int nxt = 0; nxt < v; nxt++) {
                if(visit[nxt]) continue;
                if (graph[cur][nxt] == 1) {
                    if(nxt == tar) return 1;
                    stk.push(nxt);
                }
            }
        }
        return 0;
    }
}
