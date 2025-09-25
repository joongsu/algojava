package 연습.완전탐색;    // 1525 - 퍼즐


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 퍼즐 {

    static final String TARGET = "123456780";
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 퍼즐 상태
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String line = br.readLine().replace(" ", "");
            sb.append(line);
        }

        String startState = sb.toString();

        System.out.println(bfs(startState));

    }

    public static int bfs(String startState) {

        Queue<String> q = new LinkedList<>();

        // key: 퍼즐 상태 문자열, value : 최소 이동 횟수
        Map<String, Integer> map = new HashMap<>();

        map.put(startState, 0);
        q.offer(startState);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int curDist = map.get(cur);

            if (cur.equals(TARGET)) {
                return curDist;
            }

            int zeroIdx = cur.indexOf('0');
            int r = zeroIdx / 3;
            int c = zeroIdx % 3;

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dx[dir];
                int nc = c + dy[dir];

                if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3) continue;
                int nZeroIdx = nr * 3 + nc;

                StringBuilder nextSb = new StringBuilder(cur);

                char nextChar = nextSb.charAt(nZeroIdx);
                nextSb.setCharAt(nZeroIdx, '0');
                nextSb.setCharAt(zeroIdx, nextChar);

                String nextState = nextSb.toString();

                if (!map.containsKey(nextState)) {
                    map.put(nextState, curDist + 1);
                    q.offer(nextState);
                }
            }
        }

        return -1;
    }
}
