
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static int[][] graph;
	static int d;
	static int w;
	static int k;
	static int ans;
	
	static boolean check() {
		//여기서 체크
		int check=0;
		for (int i=0; i<w; i++) {
			int check_v=1;
			for (int j=1; j<d;j++) {
				int n1=graph[j-1][i];
				int n2=graph[j][i];
				
				if(n1==n2) {
					check_v++;
				}
				else {
					check_v=1;
				}
				
				if (check_v==k) {
					check++;
					break;
				}
			}
		}
		if (check<w) {
			return false;
//			System.out.println(n+ " "+ans);

		}
		
		return true;
		}
	
	
	// count , n바꿔야할거 카운트
    // dfs로 최적화, 더 이상 교체할 필요 없으면 돌아가기
    static void dfs(int n, int count, int start) {
        if (count >= ans) {
            return; // 이미 최솟값을 넘은 경우 더 이상 진행할 필요 없음
        }

        // 종료 조건

            // 조건 만족 시 최소값 갱신
            if (check()) 
                ans = Math.min(ans, count);


        // 현재 행을 0으로 바꾸거나 1로 바꿔서 dfs 호출
        for (int i = start; i < d; i++) {
            // 현재 행을 0으로 교체하고 dfs 호출
            int[] original = graph[i].clone();
            Arrays.fill(graph[i], 0);
            dfs(n + 1, count + 1, i + 1);

            // 원상 복구 후 1로 교체하고 dfs 호출
            System.arraycopy(original, 0, graph[i], 0, w);
            Arrays.fill(graph[i], 1);
            dfs(n + 1, count + 1, i + 1);

            // 원상 복구
            System.arraycopy(original, 0, graph[i], 0, w);
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= test; t++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = k; // 초기 값은 k로 설정
            System.out.print("#" + t + " ");
            dfs(0, 0, 0);
            System.out.println(ans);
        }
    }
}
