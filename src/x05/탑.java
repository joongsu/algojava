package x05;    //2493 - 탑

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        bw.write(0 + " ");
        Deque<int[]> stack = new ArrayDeque<>();

        int n1 = Integer.parseInt(s[0]);
        stack.addFirst(new int[]{n1,1});

        for (int i = 1; i < n; i++) {
            n1 = Integer.parseInt(s[i]);
            int[] top = new int[]{n1,i+1};
            boolean found = false;

            while (!stack.isEmpty() && stack.peek()[0] < top[0]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                bw.write(0 + " ");
            }else{
                bw.write(stack.peek()[1] + " ");
            }
            stack.push(top);
        }
        bw.flush();
        bw.close();
    }
}
