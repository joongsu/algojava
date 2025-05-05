package x0D;    //15683 - 감시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시 {   // 15:10

    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];
    static int n, m, result;
    static ArrayList<int[]> cctv = new ArrayList<>();

    static int[] dx = {1, 0, -1, 0}; // 남 , 동 , 북 , 서
    static int[] dy = {0, 1, 0, -1};
    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if(oob(x,y) || board2[x][y] == 6) return;
            if(board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    static boolean oob(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctv.add(new int[]{i, j});
                }
                if (board1[i][j] == 0) {
                    result++;
                }
            }
        }

        // cctv 3개  1개당 방향 4개 4^k 번 돌려야함 4진법으로 001,002,003,010

        for (int tmp = 0; tmp < 1 << (2 * cctv.size()); tmp++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4; // 방향
                brute /= 4; // 다음 값

                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];

                int checked = board1[x][y];

                switch (checked) {  // 남 , 동 , 북 , 서 0123
                    case 1:{
                        upd(x, y, dir);
                        break;
                    }
                    case 2:{
                        //02 13
                        upd(x, y, dir);
                        upd(x, y, dir + 2);
                        break;
                    }
                    case 3:{
                        // 북 동 , 2 1 , 1 0 , 0 3 , 2 3
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        break;
                    }
                    case 4:{
                        upd(x, y, dir); // 1 2 3
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        break;
                    }
                    case 5:{
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        upd(x, y, dir + 3);
                        break;
                    }
                }
            }
            int val = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board2[i][j] == 0) {
                        val++;
                    }
                }
            }

            result = Math.min(result, val);
        }

        System.out.println(result);
    }
}
