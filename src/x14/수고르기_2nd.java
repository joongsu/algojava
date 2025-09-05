package x14;    // 2230 - 수 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2nd {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sto.nextToken());
        M = Integer.parseInt(sto.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 0, N);

        int en = 0;
        int min = Integer.MAX_VALUE;

        for (int st = 0; st < N; st++) {
            while (en < N && arr[en] - arr[st] < M) en++;

            if(en == N) break;

            min = Math.min(min, arr[en] - arr[st]);
        }

        System.out.println(min);

    }
}
