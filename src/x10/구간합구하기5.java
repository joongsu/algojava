package x10;    // 11660 - 구간 합 구하기 5


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {
    static int[][] board = new int[1030][1030];
    static int N, M;
    static int[][] d = new int[1030][1030];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                d[i][j] = d[i][j-1] + d[i - 1][j] - d[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }



        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = 0;

            ans = d[x2][y2] - d[x2][y1-1] - d[x1-1][y2] + d[x1 - 1][y1 - 1];
            // d[3][4] - d[1][4] - d[3][1] + d[1][1]
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
