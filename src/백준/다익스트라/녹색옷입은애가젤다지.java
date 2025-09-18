package 백준.다익스트라;   // 4485 - 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
    static int n;
    static int t;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dij(graph);
            t++;
        }
        System.out.println(sb);
    }

    static void dij(int[][] graph) {
        int[][] d = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], 0, n, 10000);
        }
        d[0][0] = graph[0][0];


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{d[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int cx = cur[1];
            int cy = cur[2];

            if(dist != d[cx][cy]) continue;
            if(cx == n-1 && cy == n-1) break;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;


                if (dist + graph[nx][ny] < d[nx][ny]) {
                    d[nx][ny] = dist + graph[nx][ny];
                    pq.offer(new int[]{d[nx][ny], nx, ny});
                }

            }
        }

        sb.append("Problem ").append(t).append(": ").append(d[n - 1][n - 1]).append("\n");
    }
}
