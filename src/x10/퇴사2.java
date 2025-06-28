package x10;    // 15486 - 퇴사 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {
    static int[] d = new int[15000005];
    static int n;
    static int[] t = new int[15000005];
    static int[] p = new int[15000005];
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        //d[i] = i일 까지 얻을 수 있는 최대 수익
        for (int i = 1; i <= n; i++) {
            // 아무 상담도 안 했을 경우 , i-1일 까지의 최대 수익이 i일에도 유지될 수 있게
            d[i] = Math.max(d[i], d[i - 1]);
            if (i + t[i] <= n + 1) {
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
        }
        d[n + 1] = Math.max(d[n + 1], d[n]);

        System.out.println(d[n + 1]);
    }
}
