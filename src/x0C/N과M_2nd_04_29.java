package x0C;    //  15649 - N과 M(1) 2번째 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2nd_04_29 {
    static int n, m;
    static int[] arr = new int[15];
    static boolean[] isused = new boolean[15];

    public static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(isused[i]) continue;
            isused[i] = true;
            arr[cur] = i;
            func(cur + 1);
            isused[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        func(0);
    }
}
