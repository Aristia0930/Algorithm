

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	static class Node {
		int x;
		int s;
		Node(int x,int s){
			this.x=x;
			this.s=s;
			
		}
	}
    
    static int time(List<Integer> p, int s, int s_time, List<int[]> people) {
        Queue<Node> q = new PriorityQueue<>((n1,n2)->(n1.x-n2.x));
        
        // 각 사람의 도달 시간을 큐에 넣음
        for (int i : p) {
            q.offer(new Node(people.get(i)[s],0));
        }
        
        if (q.isEmpty()) {
            return 0;
        }

        // 계단에 대기 중인 사람들의 관리 배열
        int[] s_people = new int[3]; // 최대 3명까지 대기
        int current_time = 0;
        
        // 계단에 대기 중인 사람들 처리
        while (!q.isEmpty()) {
            Node now = q.poll();  // 현재 계단에 도달한 시간
            int now_time=now.x;
            Arrays.sort(s_people);
            boolean placed = false;
            // 계단에 대기 중인 사람들 처리
            for (int i = 0; i < 3; i++) {
                if (s_people[i] <= now_time) { 
                	if(now.s==1){
                		s_people[i] = now_time + s_time;
                	}
                	else {
                    s_people[i] = now_time +1+ s_time;  // 새로 올라갈 사람
                	}
                    current_time = s_people[i];  // 마지막 사람이 내려가는 시간
                    placed = true;
                    break;
                }
            }
            
            // 자리가 없으면, 다음 시간에 다시 시도
            if (!placed) {
                q.offer(new Node(now_time + 1,1));
            }
        }
        
        return current_time;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            List<int[]> end = new ArrayList<>();
            List<int[]> people = new ArrayList<>();
            
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    graph[i][j] = a;
                    
                    if (a > 1) {
                        end.add(new int[]{i, j});
                    }
                }
            }
            
            // 각 사람들의 도달 시간을 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        people.add(new int[]{
                            Math.abs(end.get(0)[0] - i) + Math.abs(end.get(0)[1] - j),
                            Math.abs(end.get(1)[0] - i) + Math.abs(end.get(1)[1] - j)
                        });
                    }
                }
            }
            
            int time = Integer.MAX_VALUE;
            
            // 부분 집합으로 사람을 나누기
            for (int i = 0; i < (1 << people.size()); i++) {
                List<Integer> arr = new ArrayList<>();
                List<Integer> arr2 = new ArrayList<>();
                for (int j = 0; j < people.size(); j++) {
                    if ((i & (1 << j)) != 0) {
                        arr.add(j);
                    } else {
                        arr2.add(j);
                    }
                }

                int s1_x = end.get(0)[0];
                int s1_y = end.get(0)[1];
                int s2_x = end.get(1)[0];
                int s2_y = end.get(1)[1];
                
                // 각 계단에 대해 시간을 계산
                //time(부분집합, 계단 번호, 계단 시간, 사람정보 배열);
                int a = time(arr, 0, graph[s1_x][s1_y], people);
                int b = time(arr2, 1, graph[s2_x][s2_y], people);
                
                // 두 계단에서 나온 최대 시간을 계산
                int k = Math.max(a, b);
                time = Math.min(k, time);
            }
            
            System.out.println("#" + t + " " + time);
        }
    }
}
