package x10; // 1932 - 정수 삼각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
    static int[][] tri = new int[502][504];
    static int[][] d = new int[502][504];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        d[1][1] = tri[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + tri[i][j];
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d[n][i]);
        }
        System.out.println(answer);

    }
}
