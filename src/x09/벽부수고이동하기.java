package x09;    // 2206 - 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    static char[][] board = new char[1002][1002];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][][] dist = new int[2][1002][1002];
    static int bfs() {
        //z = 0 부수지 않은 경우 , z = 1 부순 경우
        for(int i = 0 ; i < n ; i++){
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
            if(cur[1] == n-1 && cur[2] == m-1) return dist[cur[0]][cur[1]][cur[2]];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (dist[cur[0]][nx][ny] == -1 && board[nx][ny] == '0') {
                    dist[cur[0]][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{cur[0], nx, ny});
                }

                if (cur[0] == 0 && board[nx][ny] == '1' && dist[1][nx][ny] == -1) {
                    dist[1][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{1, nx, ny});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();
        System.out.println(bfs());
    }
}
