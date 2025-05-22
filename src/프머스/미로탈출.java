package 프머스;

import java.util.*;

class 미로탈출 {
    static int[] s = new int[2];
    static int[] l = new int[2];
    static int[] e = new int[2];
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int bfs(String[] maps,int[] start, int[] end){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        q.offer(new int[]{start[0],start[1]});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == end[0] && cur[1] == end[1]){
                return dist[end[0]][end[1]];
            }

            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx].charAt(ny) == 'X' || dist[nx][ny] > 0) continue;
                q.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

            }
        }
        return -1;

    }

    public int solution(String[] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length();


        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ;j < m ; j++){
                if(maps[i].charAt(j) == 'S'){
                    s[0] = i;
                    s[1] = j;
                }else if(maps[i].charAt(j) == 'L'){
                    l[0] = i;
                    l[1] = j;
                }else if(maps[i].charAt(j) == 'E'){
                    e[0] = i;
                    e[1] = j;
                }
            }
        }

        int t1 = bfs(maps,s,l);
        int t2 = bfs(maps,l,e);

        if(t1!=-1 && t2 != -1){
            answer = t1 + t2;
        }else{
            answer = -1;
        }

        return answer;
    }
}
