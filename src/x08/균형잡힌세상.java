package x08;    //4949 - 균형잡힌 세상

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') stack.push(c);
                else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) isValid = false;
            if (isValid) sb.append("yes").append('\n');
            else sb.append("no").append('\n');

        }
        System.out.print(sb);

    }
}
