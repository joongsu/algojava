package x09;    // 1697 - 숨바꼭질

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int n , k;
    static int[] dist = new int[100002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        Arrays.fill(dist, 0, 100002, -1);
        dist[n] = 0;

        while (dist[k] == -1){
            int cur = q.poll();

            for (int nxt : new int[]{cur - 1, cur + 1, cur * 2}) {
                if(nxt < 0 || nxt > 100000) continue;
                if(dist[nxt] != -1) continue;

                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }
        System.out.println(dist[k]);

    }
}
