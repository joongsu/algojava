package x14;   // 1806 - 부분합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());
        N = Integer.parseInt(sto.nextToken());
        S = Integer.parseInt(sto.nextToken());

        arr = new int[N];
        sto = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }


        int en = 0;
        // 1 2 3 4 5 6 7 8 9  S = 20
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int st = 0; st < N; st++) {

            while (en < N && sum < S) {
                sum += arr[en++];
            }

            if (sum >= S) {
                min = Math.min(min, en - st);
            }

            sum -= arr[st];
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
}
