package x12;    // 1978 - 소수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
    static int n, cnt;
    static int[] arr = new int[105];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(isPrime(arr[i])) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int k) {
        if(k == 1) return false;

        for (int i = 2; i * i <= k; i++) {
            if(k % i == 0) return false;
        }
        return true;
    }
}
