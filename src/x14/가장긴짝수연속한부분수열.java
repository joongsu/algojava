package x14;    // 22862 - 가장 긴 짝수 연속한 부분 수열 (large)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sto.nextToken());
        K = Integer.parseInt(sto.nextToken());

        arr = new int[N];

        sto = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }

        int st = 0;
        int oddCnt = 0;
        int ans = 0;

        for (int en = 0; en < N; en++) {
            if((arr[en] & 1) == 1) oddCnt++;

            while (oddCnt > K) {
                if((arr[st] & 1) == 1) oddCnt--;
                st++;
            }

            int evens = (en - st + 1) - oddCnt;
            if(evens > ans) ans = evens; // 최대 길이
        }

        System.out.println(ans);

    }
}
