import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    static int num_len;
    static int change;
    static int ans;

    // back 함수 수정: 방문 여부를 Set으로 체크
    static void back(int count, int value, String[] num, Set<Integer> v) {
        if (count == change) {
            ans = Math.max(ans, value);
        } else {
            for (int i = 0; i < num_len - 1; i++) {
                for (int j = i + 1; j < num_len; j++) {
                    // 두 자리를 바꿔서 새로운 숫자를 만듦
                    String temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;

                    // 새로운 숫자를 정수로 변환
                    int rs = Integer.parseInt(String.join("", num));

                    // 방문한 적이 없다면
                    if (!v.contains(rs * 100 + count + 1)) {
                        v.add(rs * 100 + count + 1);  // 방문 기록 추가
                        back(count + 1, rs, num, v);  // 재귀 호출
                    }

                    // 다시 원상복구
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int test = 1; test <= n; test++) {
            st = new StringTokenizer(br.readLine());
            String[] num = st.nextToken().split("");  // 숫자 문자열을 쪼갬
            change = Integer.parseInt(st.nextToken()); // 변경 횟수
            num_len = num.length;
            ans = 0;
            Set<Integer> v = new HashSet<>();  // 방문 여부를 기록할 Set

            // back 함수 호출
            back(0, 0, num, v);

            // 결과 출력
            System.out.printf("#%d %d\n", test, ans);
        }
    }
}
