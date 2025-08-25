package x09;    // 5427 - 불

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 여러개불 {
    static int T, N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            char[][] board = new char[N+1][M+1];
            int[][] fireDist = new int[N + 1][M + 1];
            int[][] manDist = new int[N + 1][M + 1];

            for (int i = 0; i < N; i++) {
                Arrays.fill(fireDist[i], -1);
                Arrays.fill(manDist[i], -1);
            }

            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> man = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                        fireDist[i][j] = 0;
                    }
                    if (board[i][j] == '@') {
                        man.offer(new int[]{i, j});
                        manDist[i][j] = 0;
                    }
                }
            }

            while (!fire.isEmpty()) {
                int[] cur = fire.poll();
                int x = cur[0];
                int y = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(fireDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;

                    fireDist[nx][ny] = fireDist[x][y] + 1;
                    fire.offer(new int[]{nx, ny});
                }
            }
            boolean success = false;

            while (!man.isEmpty()) {
                int[] cur = man.poll();
                int x = cur[0];
                int y = cur[1];

                if(success) break;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        sb.append(manDist[x][y] + 1).append("\n");
                        success = true;
                        break;
                    }

                    if(manDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                    if(fireDist[nx][ny] != -1 && fireDist[nx][ny] <= manDist[x][y] + 1) continue;

                    manDist[nx][ny] = manDist[x][y] + 1;
                    man.offer(new int[]{nx, ny});
                }
            }
            if(!success) sb.append("IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);
    }
}
