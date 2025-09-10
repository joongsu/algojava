package 연습.슬라이딩윈도우; // 12847 - 꿀 아르바이트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀아르바이트 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }

        long ans = sum;

        for (int en = M; en < N; en++) {
            sum += arr[en];
            sum -= arr[en - M];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
