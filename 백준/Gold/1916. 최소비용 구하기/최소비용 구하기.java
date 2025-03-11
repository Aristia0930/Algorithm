

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Node>> array;
	
	static class Node{
		int idx;
		int cost;
		
		Node(int idx,int cost){
			this.idx=idx;
			this.cost=cost;
		}
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		
		int bus = Integer.parseInt(st.nextToken());
		
		array=new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < n + 1; i++) {
			array.add(new ArrayList<Node>());
		}

		//그래프 입력받기
		for (int i=0; i<bus;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			array.get(a).add(new Node(b,c));
			
		}
		
		//거리테이블 초기화
		int [] dist = new int[n+1];
		for (int i=0; i<n+1;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Queue<Node> q = new PriorityQueue<Node>((o1,o2)-> Integer.compare(o1.cost, o2.cost));
		
		
		
		q.offer(new Node(start,0));
		
		dist[start]=0;
		
		
		while (!q.isEmpty()) {
			
			Node node= q.poll();
			if (dist[node.idx]<node.cost) {
				continue;
			}
			
			//인접노드 탐색
			for (int i=0; i<array.get(node.idx).size();i++) {
				Node nextNode = array.get(node.idx).get(i);
				
				if(dist[nextNode.idx]>node.cost+nextNode.cost) {
					dist[nextNode.idx]=node.cost+nextNode.cost;
					q.offer(new Node(nextNode.idx,dist[nextNode.idx]));
				}
			}
		}
				
		
		
		
		
		System.out.println(dist[end]);
	}

}
