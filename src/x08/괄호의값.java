package x08;        //2504 - 괄호의값

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        int m = 1;
        int result = 0;

        for (int i = 0; i < s.length; i++) { // 분배법칙

            if (s[i].equals("(")) {
                m *= 2;
                stack.push(s[i]);
            } else if (s[i].equals("[")) {
                m *= 3;
                stack.push(s[i]);
            } else if (s[i].equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    System.out.println(0);
                    return;
                }//([()]) -> 12

                if (s[i - 1].equals("(")) result += m;
                stack.pop();
                m /= 2;
            } else if (s[i].equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    System.out.println(0);
                    return;
                }
                if (s[i - 1].equals("[")) result += m;

                stack.pop();
                m /= 3;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}
