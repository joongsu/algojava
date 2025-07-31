package x10;    // 2293 - 동전 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {
    static int N, K;
    static int[] coin = new int[105];
    static int[] d = new int[10005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // d[k] = 동전의 합이 k 값이 되는 경우의 수
        // coin[0] 일때 -> d , coin[1] 일때 -> d 누적합으로

        d[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                d[j] = d[j] + d[j - coin[i]];
            }//d[5] + d[3] -> 이전 코인을 통해 j를 만드는 경우의 수 + 현재 코인을 통해 d[j-coin[i]]을 만드는 경우의 수
        }

        System.out.println(d[K]);
    }
}
