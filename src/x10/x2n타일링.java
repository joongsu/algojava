package x10;    //11726 - 2xn 타일링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class x2n타일링 {
    static int[] d = new int[1003];
    static int n;
    public static void main(String[] args) throws IOException {
        //D[i] = 2xi 크기의 직사각형을 채우는 방법의 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
