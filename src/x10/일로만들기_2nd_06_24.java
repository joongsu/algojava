package x10;    // 1463 - 1로 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기_2nd_06_24 {
    static int n;
    static int[] d = new int[1000001];
    public static void main(String[] args) throws IOException {
        // d[i] i를 3가지 방법으로 계산했을 때 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }
        System.out.println(d[n]);
    }
}
