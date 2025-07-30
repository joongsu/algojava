package x09;    // 2206 - 벽 부수고 이동하기(2번째 풀이)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기_2nd_07_30 {
    static char[][] board = new char[1005][1005];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dist = new int[2][1005][1005];
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    static int bfs() {
        // 1 -> 벽
        // z = 1 -> 벽 부숨 , z = 0 벽 안 부숨
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[0][i][j] = -1;
                dist[1][i][j] = -1;
            }
        }

        dist[0][0][0] = dist[1][0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[1];
            int y = cur[2];
            int state = cur[0];

            if (x == n - 1 && y == m - 1) { // 종료 시점
                return dist[cur[0]][x][y];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;

                // 방문 안했고 이동할 수 있는 곳
                if (dist[state][nx][ny] == -1 && board[nx][ny] == '0') {
                    dist[state][nx][ny] = dist[state][x][y] + 1;
                    q.offer(new int[]{state, nx, ny});
                }
                // 현재 상태 -> 0 이고 벽이 있으며 벽을 부수고 처음 접한 경우(해당 칸)
                if (state == 0 && board[nx][ny] == '1' && dist[1][nx][ny] == -1) {
                    dist[1][nx][ny] = dist[state][x][y] + 1;
                    q.offer(new int[]{1, nx, ny});
                }
            }
        }
        return -1;
    }
}
