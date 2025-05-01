package x0C; // 15652 - N 과 M (4)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4 {

    static int n,m;
    static int[] arr = new int[20];
    static StringBuilder sb = new StringBuilder();
    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;
        if(cur != 0) st = arr[cur-1];

        for (int i = st; i <= n; i++) {
            arr[cur] = i;
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        System.out.println(sb);
    }
}
