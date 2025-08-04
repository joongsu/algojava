package x10;    // 7579 - 앱

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        // M 바이트 이상의 메모리를 확보 해야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] m = new int[N];
        int[] c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sumCost = 0;
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            sumCost += c[i];
        }

        // 앱을 비활성화 시켜 M이상의 메모리 확보, c 최소화
        int[] dp = new int[sumCost + 1]; // 비용 i 로 얻을 수 있는 최대 메모리

        for (int i = 0; i < N; i++) {
            for (int j = sumCost; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
        }

        int ans = 0 ;
        for (int i = 0; i <= sumCost; i++) {
            if (dp[i] >= M) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);

    }
}
