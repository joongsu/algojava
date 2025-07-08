package 백준; // 14940 - 쉬운 최단거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
    static int n, m;
    static int[][] graph = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static boolean[][] visit = new boolean[1002][1002];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n ||ny < 0 || ny >= m) continue;
                if(graph[nx][ny] == 0 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && !visit[i][j]) {
                    System.out.print(-1 + " ");
                    continue;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
