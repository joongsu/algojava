package x10; // 2156 - 포도주 시식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
    static int n;
    static int[] arr = new int[10005];
    static int[] d = new int[10005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            d[i] = arr[i];
        }

        d[1] = arr[1];
        d[2] = arr[1] + arr[2];
        // i 번째 포도주 안 마시는 경우
        // i번째 마시고 i-1 안 마신 경우
        // i번째와 i-1 모두 마신 경우
        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(
                    d[i - 1],
                    Math.max(
                            d[i - 2] + arr[i],
                            d[i - 3] + arr[i - 1] + arr[i]
                    )
            );
        }

        System.out.println(d[n]);
    }
}
