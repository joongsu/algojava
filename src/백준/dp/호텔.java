package 백준.dp;  // 1106 - 호텔

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔 {
    static int C, N;
    static int[][] v = new int[30][2];
    public static void main(String[] args) throws IOException {
        // c : 적어도 c명 늘리기 위해..
        // n : 홍보 할 수 있는 도시 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }
        // (홍보 비용, 얻을 수 있는 고객)

        //d[i] = i 명 늘리기 위한 최대 비용
        // 무한 배낭 (각 도시는 무제한으로 사용할 수 있음)
        int MAX = C + 100;
        int INF = 1000000000;

        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int cost = v[i][0];
            int add = v[i][1];

            for (int c = add; c <= MAX; c++) {
                dp[c] = Math.min(dp[c], dp[c - add] + cost);
            }
        }
        int ans = INF;
        for (int c = C; c <= MAX; c++) {
            ans = Math.min(ans, dp[c]);
        }
        System.out.println(ans);
    }
}
