package 백준.dp;  // 12865 - 평범한 배낭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    static int N, K;
    static int[] w = new int[105];
    static int[] v = new int[105];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1]; // 무게 K일떄의 가치 최대

        for (int i = 1; i <= N; i++) {

            for (int k = K; k >= w[i]; k--) {
                dp[k] = Math.max(dp[k], dp[k - w[i]] + v[i]);
            }
        }
        System.out.println(dp[K]);

    }
}
