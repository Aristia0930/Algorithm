
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans = 0;

    static void check(String[][] array) {
        for (int i = 0; i < 6; i++) {  // i는 세로
            for (int j = 0; j < 10; j++) {  // j는 가로
                // 가로 체크
                int count = 0;
                for (int k = 0; k < 5; k++) {
                    if (array[j][i + k].equals("X")) {
                        count++;
                    }
                }
                if (count == 5) {
                    ans = 1;
                }

                // 세로 체크
                count = 0;
                for (int k = 0; k < 5; k++) {
                    if (array[i + k][j].equals("X")) {
                        count++;
                    }
                }
                if (count == 5) {
                    ans = 1;
                }

                // 왼쪽 상단 -> 오른쪽 하단 대각선 체크
                count = 0;
                if ( j + 4 < 10) {  // 범위 체크
                    for (int k = 0; k < 5; k++) {
                        if (array[j + k][i + k].equals("X")) {
                            count++;
                        }
                    }
                    if (count == 5) {
                        ans = 1;
                    }
                }

                // 오른쪽 상단 -> 왼쪽 하단 대각선 체크
                count = 0;
                if ( j - 4 >= 0) {  // 범위 체크
                    for (int k = 0; k < 5; k++) {
                        if (array[j - k][i + k].equals("X")) {
                            count++;
                        }
                    }
                    if (count == 5) {
                        ans = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] array = new String[10][10];
        for (int i = 0; i < 10; i++) {
            array[i] = br.readLine().split("");
        }

        // "."을 "X"로 바꿔가며 검사
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][j].equals(".")) {
                    array[i][j] = "X";  // "."을 "X"로 바꿈
                    check(array);  // 배열을 검사
                    array[i][j] = ".";  // 원래대로 돌려놓음
                }
            }
        }

        System.out.println(ans);  // 결과 출력
    }
}
