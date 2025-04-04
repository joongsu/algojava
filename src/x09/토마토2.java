package x09;    // 7569 - 토마토2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토2 {
    static int[][][] board = new int[102][102][102];
    static int[][][] dist = new int[102][102][102];
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);


        Queue<int[]> q = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j][k] = Integer.parseInt(s1[j]);
                    if(board[i][j][k] == 1) q.offer(new int[]{i, j, k});
                    if(board[i][j][k] == 0) dist[i][j][k] = -1;
                }
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2] + dz[i];
                if(nx <0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if(board[nx][ny][nz] != 0 || dist[nx][ny][nz] != -1) continue;

                q.offer(new int[]{nx, ny, nz});
                dist[nx][ny][nz] = dist[cur[0]][cur[1]][cur[2]] + 1;
            }
        }

        int day = 0;

        for (int k = 0; k < h; k++) {
            for(int i = 0 ; i< n ; i++){
                for (int j = 0; j < m; j++) {
                    if(dist[i][j][k] == -1){
                        System.out.println(-1);
                        return;
                    }else{
                        day = Math.max(day, dist[i][j][k]);
                    }
                }
            }
        }
        System.out.println(day);
    }
}
