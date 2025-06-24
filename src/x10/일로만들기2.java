package x10;    //12852 - 1로 만들기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기2 {
    static int n;
    static int[] d = new int[1000005];
    static int[] pre = new int[1000005];
    public static void main(String[] args) throws IOException {
        //d[i] = i를 1로 만드는데 드는 연산 횟수 최소
        //d[i] = min(d[x/3] , d[x/2] , d[x-1]) + 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            pre[i] = i - 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i/2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
                pre[i] = i / 3;
            }
        }
        System.out.println(d[n]);
        int cur = n;
        while (true) {
            System.out.print(cur + " ");
            if(cur == 1) break;
            cur = pre[cur];
        }
    }
}
