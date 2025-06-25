package x10;    // 2193 - 이친수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
    static int n;
    static long[] d = new long[300];
    static long[][] v = new long[300][2];
    public static void main(String[] args) throws IOException {
        // 이진수 중 특별한 성질 갖는 수 = 이친수
        // 이친수는 0으로 시작하지 않는다 , 1이 두 번 연속으로 나타나지 않는다
        // v[i][0] = i자리 , 0 으로 끝나는...
        // v[i][1] = i자리 , 1 로 끝나는...
        // 1, 10, 100, 101,
        // 1000, 1010, 1001
        // 10000, 10001, 10101, 10100,10010 등이 이친수
        // 100000, 100001, 101001, 100101
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // s[i] = i 자리 이친수의 개수
        v[1][1] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            v[i][0] = v[i - 1][0] + v[i - 1][1];
            v[i][1] = v[i - 1][0];
            d[i] = v[i][0] + v[i][1];
        }
        System.out.println(d[n]);
    }
}
