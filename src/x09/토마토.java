package x09;    // 7576 - 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    public static void main(String[] args) throws IOException {
        //1 = 익은토마토 , 0 = 익지 않은 토마토 , -1 = 토마토가 들어있지 않은 칸

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < m ;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) q.offer(new int[]{i, j});
                if(board[i][j] == 0) dist[i][j] = -1;
            }
        }


        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx,ny});

            }
        }

        int ans = 0;
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans,dist[i][j]);
            }
        }
        System.out.println(ans);
    }
}
