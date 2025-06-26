package x01;    // 1931 - 회의실배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

    static class Meeting{
        int start,end;

        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    static int n, ans, t;
    static Meeting[] meetings;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings,(a,b) -> {
            if(a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        }); // 제일 빨리 끝나는 순서대로 정렬

        for (int i = 0; i < n; i++) {
            if(t > meetings[i].start) continue; // 스케쥴의 시작 시간이 t 이상이면 바로 회의 배정
            // 현재시간 t는 meetings[i].end
            ans++;
            t = meetings[i].end;
        }
        System.out.println(ans);
    }
}




/*
* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = new int[n + 2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 회의를 끝나는 시간이 빠른 순으로, 끝나는 시간이 같다면 시작 시간이 빠른 순으로 정렬
        // d[i] = i번째 회의를 마지막으로 진행했을 때 최대 회의의 수
        // d[i] = max(d[j]) + 1 , (j번째 회의 끝나는 시간이 i번째 회의의 시작 시간 이하의 모든 j
        Arrays.sort(arr, 0, n, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 초기화: 각 회의 하나만 선택할 수 있으므로 1
        d[0] = 1;

        // DP 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // j번째 회의가 i번째 회의보다 먼저 끝나야 겹치지 않음
                if (arr[j][1] <= arr[i][0]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        // 최대값 출력
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
    * */