package x0C;    // 1182 - 부분수열의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {

    static int[] arr = new int[30];
    static int n,s,cnt;

    static void func(int cur, int total) {
        if(cur == n){
            if(total == s) cnt++;
            return;
        }
        func(cur + 1, total);
        func(cur + 1, total + arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        func(0, 0);
        if(s==0) cnt--;
        System.out.println(cnt);
    }
}
