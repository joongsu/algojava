package x05;    //1874 - 스택수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int tmp = 1;

        for(int t = 0 ; t < n ;t++){
            int n1 = Integer.parseInt(br.readLine());

            for (; tmp <= n1; tmp++) {
                s.push(tmp);
                sb.append("+\n");
            }
            if (s.peek() == n1) {
                s.pop();
                sb.append("-\n");
            } else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
