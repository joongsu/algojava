package x09; // 14442 - 벽 부수고 이동하기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {
    static int N, M, K;
    static char[][] board = new char[1005][1005];
    static int[][][] dist = new int[11][1005][1005];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }


        System.out.println(bfs());
    }

    static int bfs() {
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // 벽을 부순 횟수, x , y

        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int state = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == N - 1 && y == M - 1) {
                return dist[state][x][y];
            }


            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                if(nx < 0 || nx >= N || ny <0 || ny >=M) continue;

                if (board[nx][ny] == '0' && dist[state][nx][ny] == -1) {
                    dist[state][nx][ny] = dist[state][x][y] + 1;
                    q.offer(new int[]{state, nx, ny});
                }

                if (state < K && board[nx][ny] == '1' && dist[state+1][nx][ny] == -1) {
                    dist[state + 1][nx][ny] = dist[state][x][y] + 1;
                    q.offer(new int[]{state + 1, nx, ny});
                }
            }
        }
        return -1;
    }
}
