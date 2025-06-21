package 백준; // 오큰수 - 17298

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수 {
    static int n;
    public static void main(String[] args) throws IOException {
        // 오큰수 = 오른쪽에 있으면서 Ai 보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
        // 그러한 수가 없으면 오큰수는 -1
        Deque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);

        for(int i = 1 ; i<arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
