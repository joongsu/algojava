package x14;    // 2003 - 수들의 합 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 시간제한 0.5 -> 5천만 연산 5 * 10^7
        // n -> 10^4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sto.nextToken());
        M = Integer.parseInt(sto.nextToken());

        arr = new int[N];

        sto = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }


        int en = 0;
        int sum = 0;
        int cnt = 0;

        for (int st = 0; st < N; st++) {
            while (en < N && sum < M) {
                sum += arr[en++];
            }
            if (sum == M) {
                cnt++;
            }

            sum -= arr[st];
        }

        System.out.println(cnt);

    }
}
