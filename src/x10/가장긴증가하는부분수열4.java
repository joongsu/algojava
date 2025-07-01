package x10;    //  14002 - 가장 긴 증가하는 부분 수열 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4 {
    static int n;
    static int[] arr = new int[1005];
    static int[] d = new int[1005];
    static int[] pre = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }
        // d[i] = i 항으로 끝날때 가장 긴 증가하는 수열의 길이
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j < i ; j++){
                if (arr[i] > arr[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int maxIndex = 1;
        int maxD = d[1];

        for (int i = 2; i <= n; i++) {
            if (maxD < d[i]) {
                maxIndex = i;
                maxD = d[i];
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int cur = maxIndex;

        while (cur > 0) {
            dq.offerFirst(arr[cur]);
            cur = pre[cur];
        }

        System.out.println(dq.size());
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }
        System.out.println(sb);

    }
}
