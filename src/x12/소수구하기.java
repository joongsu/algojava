package x12;    // 1929 - 소수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수구하기 {
    static int n, m;
    static boolean[] state = new boolean[1000005];
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(state, true);

        isPrime(m);
        for (int i : primes) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }

    public static void isPrime(int k) {
        state[1] = false;

        for (int i = 2; i * i <= k; i++) {
            if(!state[i]) continue;
            for (int j = i * i; j <= k; j += i) {
                state[j] = false;
            }
        }

        for (int i = n; i <= k; i++) {
            if(state[i]) primes.add(i);
        }
    }
}
