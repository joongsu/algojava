package x0C;    //9663 - N-Queen 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_2nd_04_29 {
    static int n,cnt;
    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];

    public static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isused1[i] || isused2[cur+i]|| isused3[cur-i + n-1])continue;
            isused1[i] = true;
            isused2[cur + i] = true;
            isused3[cur - i + n - 1] = true;
            func(cur + 1);
            isused1[i] = false;
            isused2[cur + i] = false;
            isused3[cur - i + n - 1] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        func(0);
        System.out.println(cnt);
    }
}
