package x0C;    // 15649 - N과 M(1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
    static int n,m;
    static int[] arr = new int[10];
    static boolean[] isused = new boolean[10];

    static void func(int k) { // func(0) 은 arr[0]을 정한 후에 func(1)을 호출한다.
        if (k == m) {
            for(int i = 0 ; i < m ;i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isused[i]) {
                arr[k] = i;
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
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
