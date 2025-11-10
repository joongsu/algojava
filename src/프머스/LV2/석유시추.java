package 프머스.LV2;

import java.util.*;

public class 석유시추 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m, max;

    public int solution(int[][] land) {

        n = land.length;
        m = land[0].length;

        int[][] group = new int[n][m];
        Map<Integer, Integer> groupSize = new HashMap<>();
        int groupId = 2;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(land[i][j] == 1 && group[i][j] == 0){
                    int size = bfs(land, group, i, j, groupId);
                    groupSize.put(groupId, size);
                    groupId++;
                }
            }
        }

        for(int j = 0 ; j < m ; j++){
            Set<Integer> groupsInCol = new HashSet<>();
            int colTotal = 0;


            for(int i = 0 ; i < n ; i++){
                int cur = group[i][j];

                // 중복 합산 방지
                if(cur > 1 && groupsInCol.add(cur)){
                    colTotal += groupSize.get(cur);
                }
            }
            max = Math.max(max, colTotal);
        }

        return max;
    }

    public static int bfs(int[][] land, int[][] group, int x, int y, int groupId) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        group[x][y] = groupId;
        int size = 1;


        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(group[nx][ny] != 0 || land[nx][ny] == 0) continue;

                group[nx][ny] = groupId;
                q.offer(new int[]{nx,ny});
                size++;
            }
        }
        return size;
    }
}
