package x10;    // 1912 - 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {
    static int[] d = new int[100005];
    static int[] arr = new int[100005];
    static int n;
    public static void main(String[] args) throws IOException {
        //d[i] = i번째 항으로 끝나는 연속합중 최대
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            d[i] = Math.max(d[i - 1], 0) + arr[i];
        }

        System.out.println(Arrays.stream(d, 1, n + 1).max().getAsInt());
    }
}
