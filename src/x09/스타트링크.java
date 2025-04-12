package x09;    // 5014 - 스타트링크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {

    static int[] dist = new int[10000010];
    public static void main(String[] args) throws IOException {
        // 총 F층 , 스타트링크는 G층 강호의 위치 : S층 S->G층으로 이동
        // 더이상 갈 곳 없으면 안움직임 U/D
        // 엘리베이터로 G층 갈 수 없다면 "user the stairs" 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken()); // 최고층
        int s = Integer.parseInt(st.nextToken()); // 시작지점
        int g = Integer.parseInt(st.nextToken()); // 목적지
        int u = Integer.parseInt(st.nextToken()); // 한번 누르면 u층만큼 이동
        int d = Integer.parseInt(st.nextToken()); // 한번 누르면 d층만큼 아래로 이동

        Arrays.fill(dist, 1, 1+f, -1);

        dist[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        while (!q.isEmpty()) {

            int cur = q.poll();
            for (int nxt : new int[]{cur + u, cur - d}) {
                if(nxt < 1 || nxt > f || dist[nxt] != -1) continue;

                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }
        if(dist[g] == -1) System.out.println("use the stairs");
        else{
            System.out.println(dist[g]);
        }

    }
}
