package 백준; // 1759 - 암호 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기 {
    static int L, C;
    static List<String> list = new ArrayList<>();
    static List<String> listStr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 암호 = 서로 다른 L개의 알파벳 소문자로 구성
        // 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 자음으로 구성
        // 오름차순 구성
        // 암호로 사용했을 법한 문자의 종류는 C가지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            String str = st.nextToken();
            list.add(str);
            if (str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")) {
                listStr.add(str);
            }
        }
        Collections.sort(list);
        comb(0, 0, new ArrayList<>());
        System.out.println(sb);

    }

    static void comb(int start, int cnt, List<Integer> selected) {
        if (cnt == L) {
            int count = 0;
            for (int i : selected) {
                String ch = list.get(i);
                if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")) {
                    count++;
                }
            }

            if(count == 0 || selected.size() - count < 2) return;

            for (int i : selected) {
                sb.append(list.get(i));
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            selected.add(i);
            comb(i +1 , cnt + 1 , selected);
            selected.remove(selected.size() - 1);
        }
    }
}
