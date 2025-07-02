package x18;    // 5567 - 결혼식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식 {
    static List<List<Integer>> adj = new ArrayList<>();
    static int v , e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());


        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i : adj.get(1)) {
            set.add(i);
            set.addAll(adj.get(i));
        }

        set.remove(1);
        System.out.println(set.size());

    }

    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
