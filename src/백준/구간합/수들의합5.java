package 백준.구간합; // 2018 - 수들의 합 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int st = 1 , end = 1 , sum = 1, cnt = 0;

        while (st <= n) {
            if(sum == n) cnt++;

            if (sum >= n) {
                sum -= st;
                st++;
            }else{
                end++;
                sum += end;
            }
        }
        System.out.println(cnt);
    }
}
