package x18;    // 11724 - 연결요소의개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {
    static List<List<Integer>> adj = new ArrayList<>();
    static int v,e;
    static int[] visit = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;

        for (int i = 1; i <= v; i++) {
            if(visit[i] == 1)continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visit[i] = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int k : adj.get(cur)) {
                    if(visit[k] == 1) continue;
                    visit[k] = 1;
                    q.offer(k);
                }
            }
            ans++;
        }
        System.out.println(ans);

    }

    public static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
