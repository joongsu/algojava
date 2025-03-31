package x04;    // 1406 - 에디터

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String cm = br.readLine();
            char c = cm.charAt(0);

            switch (c){
                case 'L':
                   if(iter.hasPrevious()){
                       iter.previous();
                   }
                   break;
                case 'D':
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char ch = cm.charAt(2);
                    iter.add(ch);
                default:
                    break;
            }
        }
        for (Character c1 : list) {
            bw.write(c1);
        }

        bw.flush();
        bw.close();
    }
}
