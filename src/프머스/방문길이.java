package 프머스;

import java.util.*;
class 방문길이 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][] dist = new int[11][11][5];
    static Map<Character, Integer> dirMap = Map.of(
            'U', 0,
            'R', 1,
            'D', 2,
            'L', 3
    );


    public int solution(String dirs) { // 상하좌우

        int cnt = 0;
        int x = 5, y = 5;

        for(char d : dirs.toCharArray()){
            int dir = dirMap.get(d); // 0 , 1, 2 , 3
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int dirb = (dir + 2) % 4;   // 역방향 구하기

            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            if(dist[x][y][dir] == 0 && dist[nx][ny][dirb] == 0){
                dist[x][y][dir] = 1;
                dist[nx][ny][dirb] = 1;
                cnt++;
            }
            x = nx;
            y = ny;
        }

        return cnt;
    }
}
