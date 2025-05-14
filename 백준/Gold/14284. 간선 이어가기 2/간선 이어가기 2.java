

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static class Node {
		int idx;
		int cost;
		
		Node(int idx,int cost){
			this.idx=idx;
			this.cost=cost;
		}
		
		
	}


//https://www.acmicpc.net/problem/14284
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	int n =Integer.parseInt(st.nextToken());
    	int m =Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList<ArrayList<Node>>();
    	for(int i=0; i<n+1;i++) {
    		graph.add(new ArrayList<Node>());
    		
    	}
    	
    	for(int i=0;i<m;i++) {
    		st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e,c));
			graph.get(e).add(new Node(s,c));
    		
    	}
    	st= new StringTokenizer(br.readLine());
    	int start=Integer.parseInt(st.nextToken());
    	
    	int end=Integer.parseInt(st.nextToken());
    	
		int[] dist = new int[n + 1]; // 최소 비용을 저장할 배열
		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
    	
    	
    	PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->(o1.cost-o2.cost));
    	
    	//초기값 넣기
    	q.offer(new Node(start,0));
    	dist[start]=0;
    	
    	
    	while(!q.isEmpty()) {
    		Node now=q.poll();
    		
    		if(dist[now.idx]<now.cost) {
    			continue;
    		}
    		
    		//인접노드 탐색
    		for(int i=0;i<graph.get(now.idx).size();i++) {
    			Node next=graph.get(now.idx).get(i);
    			
    			if(now.cost+next.cost<dist[next.idx]) {
    				dist[next.idx]=now.cost+next.cost;
    				q.offer(new Node(next.idx,dist[next.idx]));
    			}
    		}
    		
    	}
    	System.out.println(dist[end]);
    	

    }
}
