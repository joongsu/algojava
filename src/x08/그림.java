package x08;    //1926 - 그림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {
    static int n,m;
    static int[][] board = new int[502][502];
    static int[][] vis = new int[502][502];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(board[i][j] == 0 || vis[i][j] == 1) continue;
                count++;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                vis[i][j] = 1;
                int area = 0;

                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    area++;

                    for(int dir = 0 ; dir < 4 ; dir++){
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(board[nx][ny] != 1 || vis[nx][ny] != 0) continue;
                        q.offer(new int[]{nx, ny});
                        vis[nx][ny] = 1;
                    }
                }

                maxArea = Math.max(area, maxArea);
            }
        }

        System.out.println(count);
        System.out.println(maxArea);


    }
}
