package x10;    // 11053 - 가장 긴 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    static int n;
    static int[] arr = new int[1005];
    static int[] d = new int[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        // d[i] = i항이 마지막으로 끝날 때 가장 긴 수열의 길이

        d[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 증가 수열 조건 만족
                    d[i] = Math.max(d[j] + 1, d[i]);
                }
            }
        }
        System.out.println(Arrays.stream(d, 0, n).max().getAsInt());
    }
}
