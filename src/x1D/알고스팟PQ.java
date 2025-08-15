package x1D;    // 1261 - 알고스팟 PQ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟PQ {
    static int N, M;
    static char[][] miro = new char[105][105];
    static int[][] d = new int[105][105];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = line.charAt(j - 1);
            }
        }


        for (int i = 1; i <= N; i++) Arrays.fill(d[i], 1, M + 1, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        d[1][1] = 0;
        pq.offer(new int[]{0, 1, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[1];
            int cy = cur[2];
            int cw = cur[0];

            if(d[cx][cy] != cw) continue;

            if(cx == N && cy == M) break;
            // 방문 했던 곳이더라도 더 적은 비용으로 접근 가능할 경우 비용 갱신하고 최소힙에 넣음
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 1 || nx >N || ny < 1 ||ny > M) continue;
                int w = (miro[nx][ny] == '1') ? 1 : 0;

                if (d[nx][ny] > d[cx][cy] + w) {
                    d[nx][ny] = d[cx][cy] + w;
                    pq.offer(new int[]{d[nx][ny], nx, ny});
                }
            }
        }
        System.out.println(d[N][M]);

    }
}
