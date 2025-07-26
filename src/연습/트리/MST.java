package 연습.트리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    static int v, e;
    static int cnt = 0;
    // 정점 -> (비용, 정점 번호)
    static List<List<int[]>> adj = new ArrayList<>();
    static boolean[] chk = new boolean[10005];


    public static void main(String[] args) {
        //최소 힙
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        chk[1] = true;

        for(int[] nxt : adj.get(1)){
            pq.offer(new int[]{nxt[0], 1, nxt[1]}); // (비용, u -> v)
        }

        while (cnt < v - 1) {
            int[] cur = pq.poll();

            int cost = cur[0];
            int a = cur[1];
            int b = cur[2];

            if(chk[b]) continue;
            System.out.println(cost + " " + a + " " + b);
            chk[b] = true;
            cnt++;

            for (int[] nxt : adj.get(b)) {
                if (!chk[nxt[1]]) {
                    pq.offer(new int[]{nxt[0], b, nxt[1]});
                }
            }
        }
    }
}
