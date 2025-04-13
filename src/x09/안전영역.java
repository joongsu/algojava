package x09;    //2468 - 안전 영역

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class 안전영역 {
    static int[][] board = new int[102][102];
    static int[][] vis = new int[102][102];
    static int maxCnt,maxLimit, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int i, int j, int limit) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        vis[i][j] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(vis[nx][ny] == 1 || board[nx][ny] <= limit) continue;

                q.offer(new int[]{nx, ny});
                vis[nx][ny] = 1;

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                maxLimit = Math.max(maxLimit, board[i][j]);
            }
        }

        for (int limit = 0; limit <= maxLimit; limit++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(vis[i], 0, n, 0);
            }

            int cnt  = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > limit && vis[i][j] == 0) {
                        bfs(i, j, limit);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);

        }
        System.out.println(maxCnt);
    }
}
