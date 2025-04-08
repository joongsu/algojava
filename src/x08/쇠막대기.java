package x08;    //10799 - 쇠막대기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length; i++) {

            if (s[i].equals("(")) {
                stack.push(s[i]);
            } else if (s[i].equals(")")) {
                if (s[i - 1].equals("(")) {
                    stack.pop();
                    result += stack.size();
                }else{
                    stack.pop();
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
