package x14;    // 1644 - 소수의 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합 {
    static int N, en, sum, length;
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }

        length = primeList.size();
        // 2 3 5 7 11 13 ... N=20
        int cnt = 0;
        for (int st = 0; st < length; st++) {

            while (en < length && sum < N) {
                sum += primeList.get(en++);
            }
            if (sum == N) {
                cnt++;
            }
            sum -= primeList.get(st);
        }
        System.out.println(cnt);
    }


    static boolean isPrime(int k) {

        if(k == 1) return false;

        for (int i = 2; i <= Math.sqrt(k); i++) {
            if(k % i == 0) return false;
        }

        return true;
    }
}
