package x0D;    // 11559 - Puyo Puyo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PuyoPuyo {

    static char[][] board = new char[12][6];
    static boolean[][] visit = new boolean[12][6];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    static List<int[]> group = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 인덱스 (11,0) ~ (11,5) 까지가 바닥임

        while (true) {
            boolean isAnyBoomed = false;
            visit = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(board[i][j] == '.' || visit[i][j]) continue;
                    group.clear();
                    bfs(i, j);

                    if (group.size() >= 4) {
                        for (int[] cur : group) {
                            board[cur[0]][cur[1]] = '.';
                        }
                        isAnyBoomed = true;
                    }
                }
            }


            if(!isAnyBoomed) break;
            tblt();
            ans++;
        }
        System.out.println(ans);
    }

    static void tblt() {


        for (int i = 0; i < 6; i++) {
            char[] temp = new char[12];
            Arrays.fill(temp, '.');
            int idx = 0;


            for (int j = 11; j >= 0; j--) {
                if(board[j][i] == '.') continue;

                temp[idx++] = board[j][i];
            }
            // 덮어 씌움
            if(idx == 0) continue;
            for (int j = 11; j >= 0; j--) {
                board[j][i] = temp[11-j];
            }
        }
    }

    static void bfs(int x , int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        group.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            char c = board[cur[0]][cur[1]];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx <0 || nx > 11 || ny < 0 || ny > 5) continue;
                if(visit[nx][ny]) continue;
                if(c != board[nx][ny] || board[nx][ny] == '.') continue;
                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                group.add(new int[]{nx, ny});
            }
        }
    }
}
