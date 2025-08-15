package x1D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 알고스팟 {
    static int N, M;
    static char[][] miro = new char[105][105];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist = new int[105][105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) miro[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        // 0 빈방 , 1 벽   (1,1) -> (N,M)

        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            if(x == N-1 && y == M-1) break;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >=M ) continue;

                int w = (miro[nx][ny] == '1') ? 1 : 0;

                if (dist[nx][ny] > dist[x][y] + w) {
                    dist[nx][ny] = dist[x][y] + w;
                    if(w==0) dq.addFirst(new int[]{nx, ny});
                    else dq.addLast(new int[]{nx, ny});
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
