package 연습.슬라이딩윈도우;     // 20366 - 같이 눈사람 만들래?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같이눈사람만들래 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                int first = arr[i] + arr[j];

                int lt = i + 1;
                int rt = j - 1;

                while (lt < rt) {
                    int second = arr[lt] + arr[rt];
                    int dif = Math.abs(first - second);

                    min = Math.min(min, dif);

                    if (first > second) {
                        lt++;
                    } else if (first < second) {
                        rt--;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
