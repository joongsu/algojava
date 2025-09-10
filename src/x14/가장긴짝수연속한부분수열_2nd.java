package x14;    // 22862 - 가장 긴 짝수 연속한 부분 수열 (large)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열_2nd {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sto.nextToken());
        M = Integer.parseInt(sto.nextToken());

        arr = new int[N];

        sto = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sto.nextToken());
        }

        // 최대 M개의 홀수를 허용한다는 뜻

        int st = 0;
        int oddCnt = 0; // 현재 윈도우 안의 홀수 개수
        int ans = 0;

        for (int en = 0; en < N; en++) {
            if((arr[en] & 1) == 1 ) oddCnt++;

            // 홀수 개수가 M개를 넘어서면 왼쪽 포인터 이동시키며 줄이기
            while (oddCnt > M) {
                if((arr[st] & 1) == 1) oddCnt--;
                st++;
            }

            int evens = (en - st + 1) - oddCnt;
            if(evens > ans) ans = evens;

        }

        System.out.println(ans);
    }
}
