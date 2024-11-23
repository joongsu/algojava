package dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 백준 1012 - 유기농배추
public class uginong {
    static int T,M,N,K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

         for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];
            int count = 0 ;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[b][a] = 1;
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(graph[n][m] == 1 && !visited[n][m]){
                        dfs(n,m);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int row, int col) {  // x가 행 , y 가 열
        visited[row][col] = true;

        for(int i = 0 ; i < 4 ; i++){
            int ny = row + dy[i];
            int nx = col + dx[i];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if(graph[ny][nx] == 1 && !visited[ny][nx]) dfs(ny,nx);
        }
    }
}
