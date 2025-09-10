package 연습.슬라이딩윈도우; // 21921 - 블로그

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 블로그 {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int ans = sum;
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(ans, 1);
        for (int en = X; en < N; en++) {
            sum += arr[en];
            sum -= arr[en - X];
            cntMap.put(sum, cntMap.getOrDefault(sum, 0) + 1);
            ans = Math.max(ans, sum);
        }

        if (ans == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(ans);
            System.out.println(cntMap.get(ans));
        }

    }
}
