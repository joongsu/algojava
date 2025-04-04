package x09;    // 7562 - 나이트의 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트 {

    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};       // 시계방향
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] board = new int[302][302];
    static int[][] dist = new int[302][302];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Queue<int[]> q = new LinkedList<>();

            String[] s = br.readLine().split(" ");
            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            q.offer(new int[]{start_x, start_y});

            for(int k = 0 ; k < n ; k++)
                Arrays.fill(dist[k],-1);


            s = br.readLine().split(" ");
            int end_x = Integer.parseInt(s[0]);
            int end_y = Integer.parseInt(s[1]);

            board[end_x][end_y] = 2;

            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(board[cur[0]][cur[1]] == 2){
                    System.out.println(dist[cur[0]][cur[1]] + 1);
                    break;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(dist[nx][ny] >= 0) continue;

                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
            board[end_x][end_y] = 0;
        }
    }
}
