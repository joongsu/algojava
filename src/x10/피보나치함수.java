package x10;    // 1003 - 피보나치 함수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {
    static int t;
    static int[][] d = new int[50][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        // 0 1 1 2
        d[0][0] = 1;
        d[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            d[i][0] = d[i - 1][0] + d[i - 2][0];
            d[i][1] = d[i - 1][1] + d[i - 2][1];
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.print(d[n][0] + " " + d[n][1] + "\n");
        }
    }
}
