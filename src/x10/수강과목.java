package x10;    // 17845 - 수강과목

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수강과목 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //  최대 공부시간
        K = Integer.parseInt(st.nextToken()); // 과목 수

        int[][] a = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken()); // 중요도 , 필요한 공부시간
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10005];

        for (int i = 0; i < K; i++) {
            int I = a[i][0]; // 중요도
            int T = a[i][1]; // 공부시간

            for (int j = N; j >= T; j--) {
                dp[j] = Math.max(dp[j], dp[j - T] + I);
            }
        }
        System.out.println(dp[N]);
    }
}
