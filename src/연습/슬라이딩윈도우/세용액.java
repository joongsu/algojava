package 연습.슬라이딩윈도우; // 세 용액 - 2473

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 세용액 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] ans = new long[3];
        long minDif = Long.MAX_VALUE;

        // 첫 번째 용액 고정
        for (int i = 0; i < n - 2; i++) {
            int lt = i + 1;
            int rt = n - 1;

            while (lt < rt) {
                long dif = arr[i] + arr[lt] + arr[rt];

                if (Math.abs(dif) < minDif) {
                    minDif = Math.abs(dif);
                    ans[0] = arr[i];
                    ans[1] = arr[lt];
                    ans[2] = arr[rt];
                }

                if (dif > 0) {
                    rt--;
                } else if (dif < 0) {
                    lt++;
                }else{
                    System.out.println(arr[i] + " " + arr[lt] + " " + arr[rt]);
                    return;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
