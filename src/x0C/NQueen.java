package x0C;    // 9633 - N-Queen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    // 대각선과 열의 점유 상태를 확인
    static boolean[] isused1 = new boolean[40]; //y
    static boolean[] isused2 = new boolean[40]; // x + y
    static boolean[] isused3 = new boolean[40]; // x - y + n -1 음수방지

    static int cnt, n;

    static void func(int cur) {
        //cur 번째 행에 퀸을 둠
        if (cur == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isused1[i] || isused2[cur + i] || isused3[cur-i+ n-1]) continue;
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
