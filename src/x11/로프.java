package x11;    // 2217 - 로프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {
    static int n;
    static int[] w = new int[100005];

    public static void main(String[] args) throws IOException {
        // k개의 로프 사용 -> w 들어올릴 때 각각의 로프에 w/k 만큼 중량이 걸림
        // 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해야 함
        // 각 로프가 버틸 수 있는 최대 중량

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w, 0, n);
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[n - i] * i);
        }
        System.out.println(ans);
    }
}
