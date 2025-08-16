package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {
    static int N, M;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }
    // 조합 (중복 x)
    static void dfs(int start, int cnt, int sum) {

        if (cnt == 3) {
            if (sum <= M) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            int ns = sum + arr[i];

            if(ns > M) continue; // 가지치기
            dfs(i + 1, cnt + 1, ns);
        }
    }
}
