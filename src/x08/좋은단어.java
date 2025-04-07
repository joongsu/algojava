package x08;    //3986 - 좋은단어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int wordCount = 0;

        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek().equals(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                wordCount++;
            }
        }
        System.out.println(wordCount);

    }
}
