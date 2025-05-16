package x10;    //2579 - 계단오르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {

    static int[][] d = new int[310][3];
    static int n;
    static int[] s = new int[310];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            System.out.println(s[1]);
            return;
        }

        //d[i][j] -> 현재까지 j개의 계단을 연속해서 밟고 i 번째 계단까지 올라섬
        //d[i][1] , d[i][2]
        //d[k][1] = max(d[k-2][1],d[k-2][2]) + S[k]
        //d[k][2] = d[k-1][1] + S[k]

        d[1][1] = s[1];
        d[1][2] = 0;
        d[2][1] = s[2];
        d[2][2] = s[1] + s[2];

        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + s[i];
            d[i][2] = d[i - 1][1] + s[i];
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
