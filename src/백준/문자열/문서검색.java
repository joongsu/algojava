package 백준.문자열; // 1543 - 문서 검색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();

        String dest = br.readLine();
        int dLength = dest.length();

        int idx = 0;
        int cnt = 0;

        while (idx <= length - dLength) {
            int k = idx + dLength;

            if (s.substring(idx, k).equals(dest)) {
                cnt++;
                idx = k;
            }else{
                idx++;
            }
        }

        System.out.println(cnt);
    }
}
