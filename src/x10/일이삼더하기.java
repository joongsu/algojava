package x10;    //9095 - 1,2,3 더하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {
    static int[] d = new int[20];

    public static void main(String[] args) throws IOException {
        //d[i] = i를 1,2,3의 합으로 나타내는 방법의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n;

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < 12; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
