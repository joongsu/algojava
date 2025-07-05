package 백준; // 6603 - 로또

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 로또 {

    static int k;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            comb(0, 0, new ArrayList<>());
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void comb(int start,int cnt , List<Integer> selected) {
        if (cnt == 6) {
            Collections.sort(selected);

            for (int i : selected) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.size(); i++) {
            selected.add(i);
            comb(i + 1, cnt + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
