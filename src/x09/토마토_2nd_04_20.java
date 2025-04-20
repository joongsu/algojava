package x09;    // 7576 - 토마토 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_2nd_04_20 {
    static char[][] board = new char[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int n,m,days;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == '1') q.offer(new int[]{i, j});
                if (board[i][j] == '0') dist[i][j] = -1;
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0) continue;

                q.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, dist[i][j]);
            }
        }
        System.out.println(days);
    }
}
