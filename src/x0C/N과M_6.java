package x0C;    //15655 - N과M(6)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_6 {
    static int n, m;
    static int[] num = new int[10];
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();


    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int st = 0;
        if(cur != 0) st = arr[cur - 1] +  1;
        for (int i = st; i < n; i++) {
            arr[cur] = i;
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
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, 0, n);

        func(0);
        System.out.println(sb);
    }
}
