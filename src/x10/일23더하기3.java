package x10;    // 15988 - 1,2,3 더하기 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일23더하기3 {
    static long[] d = new long[1000001];
    static int T;
    static final long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        //d[i] = i 를 1,2,3 의 합으로 나타내는 방법 최대
        // d[3] = 3 , (2,1) , (1,2) , (1,1,1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            Arrays.fill(d, 0, k + 1, 0);

            d[1] = 1; // 1
            d[2] = 2; // 1,1  2
            d[3] = 4;   // 111,12,21,3
            for (int j = 4; j <= k; j++) {
                d[j] = (d[j - 1] + d[j - 2] + d[j - 3]) % mod;
            }

            sb.append(d[k]).append("\n");
        }

        System.out.println(sb);
    }
}
