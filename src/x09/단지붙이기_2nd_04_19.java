package x09;    //2667 - 단지붙이기 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지붙이기_2nd_04_19 {
    static char[][] board = new char[30][30];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] vis = new int[30][30];
    static int n, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = chars[j];
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1' && vis[i][j] == 0) {
                    int area = 1;
                    cnt++;

                    int[] start = new int[]{i, j};
                    Queue<int[]> q = new LinkedList<>();

                    q.offer(start);
                    vis[i][j] = 1;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(board[nx][ny] == '0' || vis[nx][ny] == 1) continue;

                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = 1;

                            area++;
                        }
                    }

                    res.add(area);
                }
            }
        }
        Collections.sort(res);

        System.out.println(cnt);

        for (int r : res) {
            System.out.println(r);
        }
    }
}
