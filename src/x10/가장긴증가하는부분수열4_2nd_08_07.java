package x10;    // 14002 - 가장 긴 증가하는 부분 수열 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4_2nd_08_07 {
    static int N;
    static int[] arr;
    static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pre = new int[N];
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        Arrays.fill(pre, -1);

        // dp[i] = i 번째 항으로 끝날 때 최대값

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }

        int idx = -1;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        Stack<Integer> stack = new Stack<>();
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = pre[idx];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
