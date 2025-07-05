package x0D;    // 12100 - 2048(Easy)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy2048 {
    static int[][] board1 = new int[21][21];
    static int[][] board2 = new int[21][21];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mx = 0;
        for (int tmp = 0; tmp < 1024; tmp++) { // 5번 기울여야 함 4^5
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board1[i][j]; // board2에 복사해서 변형 예정
                }
            }
            int brute = tmp;
            for (int i = 0; i < 5; i++) { // dir 0 일때 왼쪽 , 1일때 아래쪽, 2일때 오른쪽
                                            // dir 3 일때 위쪽
                int dir = brute % 4; // 현재 자리의 방향
                brute /= 4; // 4진수 , 다음 자리로 넘기기
                tilt(dir);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        System.out.println(mx);
    }

    static void tilt(int dir) {
        while(dir-- > 0) rotate();

        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21];
            int idx = 0;

            for (int j = 0; j < n; j++) {
                if(board2[i][j] == 0) continue;
                if (tilted[idx] == 0) { // 삽입할 위치가 비어있는 경우
                    tilted[idx] = board2[i][j];
                } else if (tilted[idx] == board2[i][j]) { // 같은 값을 갖는 블록이 충돌할 경우
                    tilted[idx++] *= 2;
                }else{
                    tilted[++idx] = board2[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                board2[i][j] = tilted[j]; // 덮어 씌움
            }
        }
    }

    static void rotate() {
        int[][] tmp = new int[21][21];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board2[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board2[i][j] = tmp[n - 1 - j][i];
            }
        }
    }
}
