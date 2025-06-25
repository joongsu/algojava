package x10;    // 11727 - 2xn 타일링2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class x2n타일링2 {
    static int n;
    static int[] d = new int[1003];
    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        // d[i] = 2xi 크기의 직사각형을 채우는 방법의 수

        d[1] = 1;
        d[2] = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 3; i <= n; i++) {
            d[i] =( (d[i-2] * 2)%mod + d[i-1]) % mod;
        }
        System.out.println(d[n]);

    }
}
