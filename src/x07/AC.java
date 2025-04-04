package x07;    // 5430 - AC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String funcString = br.readLine();
            char[] func = funcString.toCharArray();


            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            Deque<Integer> deq = new ArrayDeque<>();

            if (arrStr.length() > 2) {
                String[] numList = arrStr.substring(1, arrStr.length() - 1).split(",");
                for(String v : numList){
                    deq.offerLast(Integer.parseInt(v));
                }
            }

            boolean type = true;
            boolean err = false;
            StringBuilder sb = new StringBuilder();

            for (char f : func) {
                if(err) break;
                switch (f){
                    case 'R': type = !type;
                        break;
                    case 'D':
                        if(deq.isEmpty()){
                            sb.append("error\n");
                            err = true;
                            break;
                        }
                        if (type) {
                            deq.pollFirst();
                        }else{
                            deq.pollLast();
                        }
                        break;
                    default:
                        break;
                }
            }
            if (err) {
                System.out.println(sb);
                continue;
            }


            sb.append("[");
            while (!deq.isEmpty()) {
                sb.append(type ? deq.pollFirst() : deq.pollLast());
                if (!deq.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]\n");
            System.out.print(sb);
        }
    }
}
