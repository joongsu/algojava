package x10;    // 1149 - RGB거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {

    static int n;
    static int[] r = new int[1003];
    static int[] g = new int[1003];
    static int[] b = new int[1003];
    static int[][] d = new int[1003][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 1 번 집의 색은 2번 집의 색과 달라야 함
        // n번 집의 색은 n-1번 집의 색과 달라야 함
        // i번 집의 색은 i-1,i+1번 집의 색과 달라야 함 (2<=i<=n-1)

        //d[i][0] -> i번째 집 까지 칠하는 최소 비용, 단 i번째는 빨강

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        d[0][0] = r[0];
        d[0][1] = g[0];
        d[0][2] = b[0];
        // 빨강 선택시 min(d[k-1][1],d[k-1][2]) + r[k]
        // 초록 선택시 min(d[k-1][0], d[k-1][2]) + g[k]

        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + r[i];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + g[i];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + b[i];
        }

        int answer = Math.min(d[n - 1][0], d[n - 1][1]);
        answer = Math.min(answer, d[n - 1][2]);

        System.out.println(answer);

    }
}
