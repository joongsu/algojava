package x09;    //1012 - 유기농배추 기본문제(체크)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int T;
    static int[][] board = new int[52][52];
    static int[][] vis = new int[52][52];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());   // column
            int n = Integer.parseInt(st.nextToken()); // row
            int k = Integer.parseInt(st.nextToken());

            for(int i = 0 ; i < k ;i++){
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
            }

            Queue<int[]> q = new LinkedList<>();
            int countNum = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){

                    if(board[i][j] == 1 && vis[i][j] == 0){
                        q.offer(new int[]{i,j});
                        vis[i][j] = 1;
                        countNum++;

                        while(!q.isEmpty()){

                            int[] cur = q.poll();
                            vis[cur[0]][cur[1]] = 1;

                            for(int d = 0 ; d < 4 ; d++){
                                int nx  = cur[0] + dx[d];
                                int ny  = cur[1] + dy[d];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if(board[nx][ny] == 0 || vis[nx][ny] == 1) continue;

                                q.offer(new int[]{nx, ny});
                                vis[nx][ny] = 1;
                            }

                        }
                    }
                }
            }
            System.out.println(countNum);
            for(int i = 0 ; i < n ; i++){
                Arrays.fill(board[i],0);
                Arrays.fill(vis[i],0);
            }
        }
    }
}
