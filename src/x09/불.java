package x09;    // 4179 - 불!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불 {
    static int R, C;
    static char[][] board = new char[1005][1005];
    static int[][] fireDist = new int[1005][1005];
    static int[][] jDist = new int[1005][1005];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jDist[i], -1);
        }

        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> man = new LinkedList<>();


        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'F'){
                    fire.offer(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if (board[i][j] == 'J') {
                    man.offer(new int[]{i, j});
                    jDist[i][j] = 0;
                }
            }
        }


        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= R || ny <0 || ny >= C) continue;
                if(fireDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                fireDist[nx][ny] = fireDist[x][y] + 1;
                fire.offer(new int[]{nx, ny});
            }
        }

        while (!man.isEmpty()) {
            int[] cur = man.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(jDist[x][y] + 1);
                    return;
                }

                if(jDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if(fireDist[nx][ny] != -1 && jDist[x][y] + 1 >= fireDist[nx][ny]) continue;

                jDist[nx][ny] = jDist[x][y] + 1;
                man.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
