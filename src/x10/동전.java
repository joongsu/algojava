package x10;    // 3067 - Coins

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];
            int[] d = new int[10005];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());

            d[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <= k; j++) {
                    d[j] = d[j] + d[j - coins[i]];
                }
            }
            sb.append(d[k]).append("\n");
        }
        System.out.println(sb);
    }
}
