package 프머스;

import java.util.*;

class 무인도여행 {

    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        int[][] visit = new int[n+10][m+10] ;

        // X 바다 , 숫자는 무인도 (식량 나타냄 ) , 상하좌우 연결된 땅들은 하나의 무인도
        // 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지 나타냄
        List<Integer> list = new ArrayList<>();

        int cnt = -1;
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(maps[i].charAt(j) != 'X' && visit[i][j] == 0){
                    cnt = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visit[i][j] = 1;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        cnt += (maps[cur[0]].charAt(cur[1]) - '0');

                        for(int dir = 0 ; dir < 4 ; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(maps[nx].charAt(ny) == 'X' || visit[nx][ny] == 1) continue;
                            visit[nx][ny] = 1;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        if(cnt == -1) list.add(cnt);
        int[] answer = list.stream().sorted().mapToInt(i->i).toArray();



        return answer;
    }
}