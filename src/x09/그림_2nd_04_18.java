package x09;    //1926 - 그림 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_2nd_04_18 {
    static int n,m,cnt;
    static int[][] board = new int[501][501];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxArea;
    static int[][] vis = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {

                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    int area = 1;
                    q.offer(new int[]{i, j});
                    vis[i][j] = 1;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(board[nx][ny] == 0 || vis[nx][ny] == 1) continue;

                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = 1;
                            area++;
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxArea);
    }
}
