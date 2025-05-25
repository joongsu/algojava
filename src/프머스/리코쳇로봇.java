package 프머스;

import java.util.*;

class 리코쳇로봇 {
    static int n,m,ex,ey;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i].charAt(j) == 'R'){
                    q.offer(new int[]{i,j,0});
                }
                if(board[i].charAt(j) == 'G'){
                    ex = i;
                    ey = j;
                }
            }
        }
        int[][] visit = new int[n][m];

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == ex && cur[1] == ey){
                answer = cur[2];
                break;
            }

            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = cur[0];
                int ny = cur[1];

                while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx].charAt(ny) != 'D'){
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx -= dx[dir];
                ny -= dy[dir];

                if(visit[nx][ny] == 1) continue;

                visit[nx][ny] = 1;
                q.offer(new int[]{nx,ny,cur[2] + 1});

            }
        }
        return answer;
    }
}
