package x10;    //2579 - 계단오르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2nd_06_24 {
    static int n;
    static int[] s = new int[310];
    static int[][] d = new int[310][3];
    public static void main(String[] args) throws IOException {
        //테이블정의 -> 점화식 찾기 -> 초기값 정하기
        // n-2 -> n , 연속 x n-1 -> n

        // d[i] = i 번째 계단까지 올라섰을 때 점수 합의 최대값
        // d[i][j] = 현재 j개의 계단을 연속해서 밟고 , i번째 계단까지 올라섰을 때
        // 점수 합의 최대값 , 단 i번째 계단은 반드시 밟아야 함

        // d[k][1] = max(d[k-2][1],d[k-2][2]) + s[k]
        // d[k][2] = d[k-1][1] + s[k]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            System.out.println(s[1]);
            return;
        }

        d[1][1] = s[1];
        d[1][2] = 0;
        d[2][1] = s[2];
        d[2][2] = s[1] + s[2];

        for (int k = 3; k <= n; k++) {
            d[k][1] = Math.max(d[k-2][1],d[k-2][2]) + s[k];
            d[k][2] = d[k-1][1] + s[k];
        }
        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
