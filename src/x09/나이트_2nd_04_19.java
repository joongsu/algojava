package x09;    // 7562 - 나이트의 이동 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트_2nd_04_19 {
    static int t,n;
    static int[][] board = new int[301][301];
    static int[][] dist = new int[301][301];
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            String[] s1 = br.readLine().split("\\s+");
            int[] s = new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])};

            s1 = br.readLine().split("\\s+");
            int[] goal = new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])};

            Queue<int[]> q = new LinkedList<>();
            q.offer(s);

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i],-1);
            }

            board[goal[0]][goal[1]] = -1;
            dist[s[0]][s[1]] = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                if(cur[0] == goal[0] && cur[1] == goal[1]){
                    System.out.println(dist[cur[0]][cur[1]]);
                    break;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n ) continue;
                    if(dist[nx][ny] >= 0) continue;
                    q.offer(new int[]{nx,ny});
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
            board[goal[0]][goal[1]] = 0;
        }
    }
}
