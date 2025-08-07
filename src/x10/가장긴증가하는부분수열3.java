package x10;    // 12738 - 가장 긴 증가하는 부분 수열 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열3 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        List<Long> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 0; i < N; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            }else{
                int pos = lowerBound(lis, arr[i]);
                lis.set(pos, arr[i]);
            }
        }
        System.out.println(lis.size());
    }

    static int lowerBound(List<Long> list, long tar) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if(list.get(mid) >= tar) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
