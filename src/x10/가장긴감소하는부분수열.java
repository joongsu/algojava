package x10;    // 11722 - 가장 긴 감소하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {
    static int N;
    static int[] arr = new int[1005];
    static int[] d = new int[1005];
    public static void main(String[] args) throws IOException {
        // 부분 수열의 길이 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        // d[i] = i항이 마지막으로 끝날 때 수열의 길이

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(d, 0, N).max().getAsInt());
    }
}
