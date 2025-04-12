package x08;    // 2583 - 영역 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {
    static int[][] board = new int[102][102];
    static int[][] vis = new int[102][102];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);

        while (k-- > 0) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[1]);
            int y1 = Integer.parseInt(s[0]);
            int x2 = Integer.parseInt(s[3]);
            int y2 = Integer.parseInt(s[2]);

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = 1;
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1 || vis[i][j] == 1) continue;

                Queue<int[]> q = new LinkedList<>();

                q.offer(new int[]{i, j});
                vis[i][j] = 1;
                int area = 1;
                count++;


                while (!q.isEmpty()) {
                    int[] cur = q.poll();


                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if(nx < 0 || ny < 0 || nx >= n || ny>=m) continue;
                        if(vis[nx][ny] == 1 || board[nx][ny] == 1) continue;
                        vis[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        area++;
                    }
                }
                res.add(area);
            }
        }
        System.out.println(count);
        Collections.sort(res);

        for (int r : res) {
            System.out.print(r + " ");
        }

    }
}






