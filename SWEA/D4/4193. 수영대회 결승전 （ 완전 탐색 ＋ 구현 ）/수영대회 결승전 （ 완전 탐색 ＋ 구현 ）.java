import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            // 방문 처리
            boolean[][] visited = new boolean[n][n];
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            int ans = bfs(sx, sy, array, visited, n, ex, ey);
            System.out.printf("#%d %d",t,ans);
            System.out.println();
        }
    }

    public static int bfs(int x, int y, int[][] graph, boolean[][] visited, int n, int endx, int endy) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0)); // 시작점과 초기 시간
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int xi = nowNode.x;
            int yi = nowNode.y;
            int time = nowNode.time;

            // 도착점에 도달
            if (xi == endx && yi == endy) {
                return time;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = xi + dx[i];
                int ny = yi + dy[i];

                // 범위 확인 및 방문 여부 확인
                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    // 빈칸 또는 소용돌이 이동 가능 시간 확인
                    if (graph[nx][ny] == 0 || (graph[nx][ny] == 2 && (time + 1) % 3 == 0)) {
                        q.offer(new Node(nx, ny, time + 1));
                        visited[nx][ny] = true;
                    } else if (graph[nx][ny] == 2) {
                        // 소용돌이 대기
                        q.offer(new Node(xi, yi, time + 1));
                    }
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }

}