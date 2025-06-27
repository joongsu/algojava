package x10;        // 14501 - 퇴사(dp)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사 {
    static int n;
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int[] d = new int[20];
    public static void main(String[] args) throws IOException {
        //d[i] -> i일날 시작한 상담의 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        //d[i] = i번째 일에 상담을 했을 때와 상담을 하지 않았을 때 얻을 수 있는 수익 중 최대 수익

        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) {
                d[i] = Math.max(d[i + t[i]] + p[i], d[i + 1]);
            }else{
                d[i] = d[i + 1];
            }
        }

        System.out.println(Arrays.stream(d,1,n+1).max().getAsInt());

    }
}
