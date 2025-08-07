package x10;    // 14003 - 가장 긴 증가하는 부분수열 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴증가하는부분수열5 {
    static int N;
    static long[] a = new long[1000005];
    static int[] prev = new int[1000005]; // 역추적용
    static int[] index = new int[1000005]; // a[i]가 lis의 몇 번째 위치인지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        List<Long> lis = new ArrayList<>();
        lis.add(a[0]);
        index[0] = 0; // lis 배열의 0번째에 들어갔다는 뜻
        prev[0] = -1; // 첫 원소이므로 이전 원소 없음


        for (int i = 1; i < N; i++) {
            if (a[i] > lis.get(lis.size() - 1)) { // 증가 수열의 가장 마지막 원소보다 크면 lis에 바로 추가
                prev[i] = index[lis.size() - 1];
                lis.add(a[i]);
                index[lis.size() - 1] = i;
            }else{ // 이진탐색 위치 찾아 교체 (가운데에 끼우는거임)
                int pos = lowerBound(lis, a[i]);
                lis.set(pos, a[i]);
                index[pos] = i;
                prev[i] = pos == 0 ? -1 : index[pos - 1];
            }
        }

        int len = lis.size();
        System.out.println(len);

        Stack<Long> stack = new Stack<>();
        int curIdx = index[lis.size() - 1];
        while (curIdx != -1) {
            stack.push(a[curIdx]);
            curIdx = prev[curIdx];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }

    static int lowerBound(List<Long> arr, long target) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(arr.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
