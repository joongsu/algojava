package x10;    // 12865 - 평범한 배낭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    static int N, K;
    static int[][] a = new int[105][2];
    public static void main(String[] args) throws IOException {
        // W : 무게 , V : 가치 , K : 넣을 수 있는 무게 최대
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }// (무게, 가치)
        int[] dp = new int[100005]; // dp[i] -> i 무게의 최대 가치

        for (int i = 0; i < N; i++) {
            int w = a[i][0];
            int v = a[i][1];

            // 제한 무게 K 이하로 담았을 때 얻을 수 있는 최대 가치 구하기
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        System.out.println(dp[K]);

    }
}
