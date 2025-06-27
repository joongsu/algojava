package x10;    // 9461 - 파도반 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    static int t;
    static long[] d = new long[110];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= 100; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
