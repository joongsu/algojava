package 백준; // 연구소 - 14502

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static int n, m,answer;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(cnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] copyBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyBoard[i] = board[i].clone();
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (copyBoard[nx][ny] != 0) continue;

                q.offer(new int[]{nx, ny});
                copyBoard[nx][ny] = 2;
            }
        }
        int cnt = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.max(cnt, answer);
    }
}
