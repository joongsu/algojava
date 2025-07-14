package 백준; // 2630 - 색종이 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
    static int[][] board = new int[128][128];
    static int n;
    static int white;
    static int blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, n);

        System.out.println(white);
        System.out.println(blue);

    }

    static void search(int row, int col, int size) {

        // chk
        if (chkColor(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            }else{
                blue++;
            }
            return;
        }

        int halfSize = size / 2;

        search(row, col, halfSize); // 11시
        search(row, col + halfSize, halfSize); // 1시
        search(row + halfSize, col, halfSize); // 7시
        search(row + halfSize, col + halfSize, halfSize); // 5시
    }

    static boolean chkColor(int row,int col, int size) {
        int color = board[row][col]; // 시작 지점 기준

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
