
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M;  // 하나의 집이 지불할 수 있는 비용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 도시 크기
            M = Integer.parseInt(st.nextToken());  // 하나의 집이 지불할 수 있는 비용

            int[][] city = new int[N][N];


            // 도시 정보 입력 및 집 위치 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    city[i][j] = Integer.parseInt(st.nextToken());
                    if (city[i][j] == 1) {

                    }
                }
            }

            int maxHomes = 0;

            // 모든 위치에서 BFS 실행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxHomes = Math.max(maxHomes, bfs(N, city, i, j));
                }
            }

            System.out.println("#" + test_case + " " + maxHomes);
        }
        br.close();
    }

    // BFS 탐색
    static int bfs(int N, int[][] city, int startX, int startY) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1}); // {x, y, depth}
        visited[startX][startY] = true;

        int homeCount = (city[startX][startY] == 1) ? 1 : 0;
        int maxHomes = 0;
        int K = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int operationCost = K * K + (K - 1) * (K - 1);

            // 운영 비용과 수익 비교 후 최대 집 수 업데이트
            if (homeCount * M >= operationCost) {
                maxHomes = Math.max(maxHomes, homeCount);
            }

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                // 4방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, K + 1});
                        if (city[nx][ny] == 1) {
                            homeCount++;
                        }
                    }
                }
            }
            K++;
        }
        return maxHomes;
    }
}