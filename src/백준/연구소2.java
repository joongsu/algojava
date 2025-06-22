package 백준; // 연구소 2 - 17141

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소2 {
    static int n,m;
    static int[][] board;
    static int[][] dist;
    static int answer = Integer.MAX_VALUE;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> activeVirus = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) virus.add(new int[]{i, j});
            }
        }
        dfs(0, 0);


        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public  static  void dfs(int depth , int start) {
        if(depth == m){
            bfs();
            return;
        }
        // 바이러스 모든 조합
        for (int i = start; i < virus.size(); i++) {
            activeVirus.add(virus.get(i));
            dfs(depth + 1, i + 1);
            activeVirus.remove(activeVirus.size() - 1);
        }
    }

    public static void bfs() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int[] v : activeVirus) {
            q.offer(v);
            dist[v[0]][v[1]] = 0;
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(dist[nx][ny] > -1 ||board[nx][ny] == 1) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 1) {
                    if (dist[i][j] == -1) return;
                    maxTime = Math.max(maxTime, dist[i][j]);
                }
            }
        }
        answer = Math.min(answer, maxTime);
    }
}
