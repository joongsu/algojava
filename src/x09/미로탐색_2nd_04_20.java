package x09;    // 2178 - 미로탐색 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탐색_2nd_04_20 {
    static int n,m;
    static String[] board = new String[102];
    static int[][] dist = new int[102][102];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
            Arrays.fill(dist[i], 0, m, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if((cur[0]+1) == n && (cur[1] + 1) == m){
                System.out.println(dist[cur[0]][cur[1]]);
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
                if(board[nx].charAt(ny) != '1' || dist[nx][ny] != -1)continue;

                q.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }

    }
}


