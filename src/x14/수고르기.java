package x14;    // 2230 - 수 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
    static int N, M;
    static int[] arr = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, 0, N);

        int en = 0;
        int min = Integer.MAX_VALUE;
        for (int start = 0; start < N; start++) {
            while (en < N && arr[en] - arr[start] < M) en++;
            if(en == N) break; // en이 범위를 벗어날 시 종료
            min = Math.min(min, arr[en] - arr[start]);
        }
        System.out.println(min);
    }
}
