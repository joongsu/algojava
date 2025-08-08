package 백준.dp;  // 14501 - 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N;
    static int[][] v = new int[20][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }
        // (상담 걸리는 시간, 수익)
        // 얻을 수 있는 최대 수익

        int[] dp = new int[N + 2]; // dp[i] = i일 부터 시작해서 마지막 날까지 얻을 수 있는 최대 수익

        for (int i = N; i >= 1; i--) {
            int end = i + v[i][0]; // 상담이 끝난 날
            if (end <= N + 1) { // i일에 상담 할 수 있으면
                dp[i] = Math.max(dp[i + 1], v[i][1] + dp[end]);
            }else{ // i일에 상담을 할 수 없으면
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
