package x0C;    //15656 - N과M(7)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_7 {
    static int[] arr = new int[10];
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] num = new int[10];

    static void func(int cur) {

        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            num[cur] = arr[i];
            func(cur + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,0,n);

        func(0);
        System.out.println(sb);

    }
}
