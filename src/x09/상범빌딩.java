package x09;    // 6593 - 상범 빌딩

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {

    static int L,R,C;
    static char[][][] board = new char[32][32][32];
    static int[][][] dist = new int[32][32][32];
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int cnt;

    static void bfs(int[] start) {

        for (int z = 0; z < L; z++)
            for (int x = 0; x < R; x++)
                Arrays.fill(dist[z][x],-1);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start[0],start[1],start[2]});
        dist[start[0]][start[1]][start[2]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (board[cur[0]][cur[1]][cur[2]] == 'E') {
                System.out.println("Escaped in "+dist[cur[0]][cur[1]][cur[2]]+" minute(s).");
                return;
            }

            for (int dir = 0; dir < 6; dir++) {
                int nz = cur[0] + dz[dir];
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) continue;
                if(dist[nz][nx][ny] != -1 ||board[nz][nx][ny] == '#') continue;

                q.offer(new int[]{nz, nx, ny});
                dist[nz][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;

            }
        }
        System.out.println("Trapped!");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //막힌 칸 # , 비어있는 칸 . , 시작 지점 S , 출구 E

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());


            if (L == 0 && R == 0 && C == 0) break;

            int[] start = null;
            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++){
                    char[] chars = br.readLine().toCharArray();
                    for (int y = 0; y < C; y++) {
                        board[z][x][y] = chars[y];
                        if(board[z][x][y] == 'S') start = new int[]{z, x, y};
                    }

                }
                br.readLine();
            }

            if(start != null){
                bfs(start);
            }
        }
    }
}
