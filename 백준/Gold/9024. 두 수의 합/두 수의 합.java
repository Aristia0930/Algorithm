import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int test = 0; test < t; test++) {
            // 첫 번째 줄: n과 k 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 두 번째 줄: 배열의 값 입력
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 배열을 오름차순으로 정렬
            Arrays.sort(arr);

            int left = 0;
            int right = arr.length - 1;
            int value = Integer.MAX_VALUE;
            int count = 0;

            while (left < right) {
                int sum = arr[left] + arr[right];
                int rs = Math.abs(k- sum);

                if (rs < value) {
                    value = rs;
                    count = 1;
                } else if (rs == value) {
                    count++;
                  
                }
                
                if (sum < k) {
                    left++;
                }
      
                else {
                    right--;
                }

            }

            System.out.println(count);
        }
    }
}
