package 백준.완전탐색;    // 1987 - 알파벳

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    static char[][] graph = new char[25][25];
    static int R, C;
    static boolean[] vis = new boolean[30];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        vis[graph[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);

    }

    static void dfs(int cx , int cy, int depth) {
        max = Math.max(max, depth);

        for (int dir = 0; dir < 4; dir++) {
            int nx = dx[dir] + cx;
            int ny = dy[dir] + cy;
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            int idx = graph[nx][ny] - 'A';
            if(vis[idx]) continue;

            vis[idx] = true;
            dfs(nx,ny, depth + 1);
            vis[idx] = false;
        }

    }
}
