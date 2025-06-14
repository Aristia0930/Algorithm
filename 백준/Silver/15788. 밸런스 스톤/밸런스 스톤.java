
import java.io.*;
import java.util.*;

public class Main {
    static int N, y, x;
    static long[][] map;
    static long s, sum;

    public static void main(String[] args) throws Exception {
        input();
        calcM();

        if (checkLeftCross() && checkRightCross() && checkRow() && checkCol()) {
            System.out.println(map[y][x]);
        } else {
            System.out.println(-1);
        }
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
                if (map[i][j] == 0) {
                    y = i;
                    x = j;
                }
            }
        }
    }

    static void calcM() {
        // 기준 합 구하기
        for (int i = 0; i < 2; i++) {
            long tempSum = 0;
            for (int j = 0; j < N; j++) {
                tempSum += map[i][j];
            }
            sum = Math.max(sum, tempSum);
        }

        // 비어있는 줄의 합
        s = 0;
        for (int i = 0; i < N; i++) {
            s += map[y][i];
        }

        map[y][x] = sum - s;
    }

    static boolean checkLeftCross() {
        s = 0;
        for (int i = 0; i < N; i++) {
            s += map[i][i];
        }
        return s == sum;
    }

    static boolean checkRightCross() {
        s = 0;
        for (int i = 0; i < N; i++) {
            s += map[N - 1 - i][i];
        }
        return s == sum;
    }

    static boolean checkRow() {
        for (int i = 0; i < N; i++) {
            s = 0;
            for (int j = 0; j < N; j++) {
                s += map[i][j];
            }
            if (s != sum) return false;
        }
        return true;
    }

    static boolean checkCol() {
        for (int i = 0; i < N; i++) {
            s = 0;
            for (int j = 0; j < N; j++) {
                s += map[j][i];
            }
            if (s != sum) return false;
        }
        return true;
    }
}
