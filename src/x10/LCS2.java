package x10;    // 9252 - LCS2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);

        Stack<Character> stack = new Stack<>();
        int i = s1.length();
        int j = s2.length();

        while (i >= 1 && j >= 1) {
            if(dp[i][j] == dp[i-1][j]) i--;
            else if(dp[i][j] == dp[i][j-1]) j--;
            else{
                stack.push(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);


    }
}
