package x09;    //2667 - 단지붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지붙이기 {
    static String[] board = new String[30];
    static int[][] vis = new int[30][30];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(board[i].charAt(j) == '0' || vis[i][j] == 1) continue;

                q.offer(new int[]{i, j});
                vis[i][j] = 1;
                int area = 1;
                cnt++;

                while (!q.isEmpty()) {

                    int[] cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if(nx < 0 || nx >=n || ny <0 || ny >= n) continue;
                        if(board[nx].charAt(ny) == '0' || vis[nx][ny] == 1) continue;

                        q.offer(new int[]{nx, ny});
                        vis[nx][ny] = 1;
                        area++;
                    }
                }

                res.add(area);
            }
        }
        System.out.println(cnt);
        Collections.sort(res);

        for (int result : res) {
            System.out.println(result);
        }
    }
}
