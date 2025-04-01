package x04;        // 5397-키로거

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class 키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                switch (c){
                    case '<':
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                }
            }
            for (Character c1 : list) {
                bw.write(c1);
            }
            bw.write('\n');
            bw.flush();
        }
        bw.close();
    }
}
