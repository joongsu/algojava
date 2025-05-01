package x0C;    // 15654 - N과M(5)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M_5 {
    static int n,m;
    static int[] arr = new int[20];
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isused = new boolean[10];
    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isused[i]) continue;
            isused[i] = true;
            arr[cur] = list.get(i);
            func(cur + 1);
            isused[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(null);

        func(0);
        System.out.println(sb);
    }
}
