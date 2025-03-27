package x08; // 10026 - 적록색약(기본)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
    static String[] board = new String[102];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] vis = new int[102][102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }
        for (int t = 0; t < 2; t++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j] == 0) {
                        count++;

                        char c = board[i].charAt(j);
                        Queue<int[]> q = new LinkedList<>();

                        q.offer(new int[]{i, j});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            char cur_char = board[cur[0]].charAt(cur[1]);
                            vis[cur[0]][cur[1]] = 1;

                            for (int d = 0; d < 4; d++) {
                                int nx = cur[0] + dx[d];
                                int ny = cur[1] + dy[d];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (vis[nx][ny] == 1 ||board[nx].charAt(ny) != cur_char) continue;

                                q.offer(new int[]{nx, ny});
                                vis[nx][ny] = 1;
                            }

                        }
                    }
                }
            }
            System.out.print(count + " ");

            for (int i = 0; i < n; i++) {
                Arrays.fill(vis[i], 0);
                board[i] = board[i].replace('G', 'R');
            }
        }


    }
}
