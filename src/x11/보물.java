package x11;    // 1026 - 보물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물 {
    static int n;
    static int[] arr = new int[51];
    static int[] brr = new int[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0, n);
        Arrays.sort(brr, 0, n);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += arr[i] * brr[n - 1 - i];
        }

        System.out.println(ans);

    }
}
