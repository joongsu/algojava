package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_완탐풀이 {
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
        System.out.println(max);
    }

    public static void dfs(int day, int sum) {
        if(day > n+1) return;
        max = Math.max(max, sum);

        for (int i = day; i <= n; i++) {
            if (i + t[i] <= n + 1) {
                dfs(i + t[i], sum + p[i]);
            }
        }
    }
}
