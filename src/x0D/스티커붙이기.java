package x0D;    // 18808 - 스티커붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커붙이기 {
    static int n,m, k;
    static int[][] map = new int[42][42];
    static int[][] sticker = new int[12][12];
    static int r,c;

    static boolean pastable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[x+i][y+j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) {
                    map[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    static void rotate() {
        int[][] tmp = new int[12][12];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                tmp[i][j] = sticker[i][j];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = tmp[r - 1 - j][i]; // 전치 개념이라 r에서 빼줌
            }
        }
        swap(); // r x c -> c x r
    }

    static void swap() {
        int temp = r;
        r = c;
        c = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);


        for (int z = 0; z < k; z++) {
            String[] sizeInfo = br.readLine().split(" ");
            r = Integer.parseInt(sizeInfo[0]);
            c = Integer.parseInt(sizeInfo[1]);

            for (int i = 0; i < r; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //스티커 다 만들어짐


            for (int rot = 0; rot < 4; rot++) {
                boolean is_paste = false;
                for (int x = 0; x <= n - r; x++) {
                    if(is_paste) break;
                    for (int y = 0; y <= m - c; y++) {
                        if (pastable(x, y)) {
                            is_paste = true;
                            break;
                        }
                    }
                }
                if(is_paste) break;
                rotate();   // 붙일 수 없는 경우 회전으로 확인
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += map[i][j];
            }
        }
        System.out.print(cnt + "\n");
    }
}
