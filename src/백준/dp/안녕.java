package 백준.dp;  // 1535 - 안녕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안녕 {
    static int N;
    static int[] lose = new int[105];
    static int[] joy = new int[105];
    public static void main(String[] args) throws IOException {
        // 잃는 체력 1번 사람부터 순서대로
        // 얻는 기쁨이 1번 사람부터 순서대로 0~100 으로 들어옴
        // N <= 20

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lose[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int CAP = 99;
        int[] dp = new int[CAP + 1]; // dp[h] = 체력 h만큼 잃을 수 있을 때 얻는 최대 기쁨

        for (int i = 1; i <= N; i++) {
            int w = lose[i];
            int v = joy[i];

            for (int h = CAP; h >= w; h--) {
                dp[h] = Math.max(dp[h], dp[h - w] + v);
            }
        }

        System.out.println(dp[CAP]);
    }
}
