package x14;    // 1806 - 부분합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_2sol {
    static int N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        N = Integer.parseInt(sto.nextToken());
        S = Integer.parseInt(sto.nextToken());

        int[] arr = new int[N];

        sto = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }

        int en = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;

        for (int st = 0; st < N; st++) {

            while (en < N && sum < S) {
                en++;
                if(en != N) sum += arr[en];
            }
            if(en == N) break;

            if (sum >= S) {
                min = Math.min(min, en - st + 1);
            }
            sum -= arr[st];
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
