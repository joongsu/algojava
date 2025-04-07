package x08;    // 9012 - 괄호


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) isValid = false;
            if (isValid) {
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }
}
