package 백준.구간합; // 2559 - 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        // N 전체 날짜의 수
        // K 연속적인 날짜의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }
        int max = sum;  // 0~K-1

        for (int i = K; i < N; i++) {
            sum += (temp[i] - temp[i - K]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
