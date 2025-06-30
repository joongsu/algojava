package 프머스.알고리즘고득점kit.깊이너비우선탐색;

import java.util.*;
class 게임맵최단거리 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] dist;
    public int solution(int[][] mapsInput) {
        int n = mapsInput.length; // 5
        int m = mapsInput[0].length; // 5
        map = mapsInput;
        dist = new int[map.length][map[0].length];
        for(int i =0  ; i< map.length ;i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> q = new LinkedList<>();
        // 0 은 벽 , 1 은 벽이 없는 자리 , 0,0 시작 상대 n,m
        q.offer(new int[]{0,0});
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == n-1 && y == m-1){
                break;
            }

            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                if(dist[nx][ny] >= 0 || map[nx][ny] == 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }


        return dist[n-1][m-1];
    }
}
