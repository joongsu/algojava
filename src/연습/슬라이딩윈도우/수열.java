package 연습.슬라이딩윈도우; // 2559 - 수열


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int ans = sum;
        // 고정 길이 슬라이딩 윈도우

        for (int i = K; i < N; i++) {
            sum += arr[i];
            sum -= arr[i - K]; // 맨 앞 원소 빼기
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
