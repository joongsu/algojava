package x0B;    // 11729 - 하노이탑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑 {
    static StringBuilder sb;
    static void func(int a, int b, int n) {

        if (n == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }

        func(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        func(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        sb.append((int) Math.pow(2, n) - 1).append("\n");
        func(1, 3, n);

        br.close();
        System.out.println(sb);
    }
}
