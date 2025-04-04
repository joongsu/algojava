package x09;    // 2178 - 미로탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탐색 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist = new int[102][102],N, M;
    static String[] board = new String[102];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 0, m, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx].charAt(ny) == '0' || dist[nx][ny] >= 1) continue;  // 미방문 아래로

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // 중복 방지를 위한 미리 방문
                q.offer(new int[]{nx, ny});
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}
