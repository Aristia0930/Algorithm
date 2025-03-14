

import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	
	static class Node{
		int x;
		int y;
		int cost;
		
		
		
		Node(int x,int y, int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		for(int test=1;test<t+1;test++) {
			st=new StringTokenizer(br.readLine());
			
			int n=Integer.parseInt(st.nextToken());
			
			//그래프
			List<List<Integer>> graph=new ArrayList<List<Integer>>();
			for (int i=0;i<n;i++) {
				graph.add(new ArrayList<Integer>());
			}
			int[][] d=new int [n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    graph.get(i).add(line.charAt(j) - '0');  // 문자 '0'과 '1'을 숫자로 변환
                    d[i][j] = Integer.MAX_VALUE;  // d 배열을 초기화
                }
            }
			d[0][0]=0;
	
			
			
			PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n1->n1.cost));
			q.offer(new Node(0,0,0));
			
			while (!q.isEmpty()) {
				Node node=q.poll();
				
				if (d[node.x][node.y]<node.cost){
					continue;
				}
				
				//그래프 탐색
				for (int i=0;i<4;i++) {
					int idx=node.x+dx[i];
					int idy=node.y+dy[i];
					
					if(0<=idx && idx<n && 0<=idy && idy<n) {
						Node next=new Node(idx,idy,graph.get(idx).get(idy));
						if (d[idx][idy]>d[node.x][node.y]+next.cost) {
							d[idx][idy]=d[node.x][node.y]+next.cost;
							q.offer(next);
						}
						
						
					}
				}
				
			}
			System.out.printf("#%d %d",test,d[n-1][n-1]);
			System.out.println();
			
			
			
		}
	}

}
