import java.util.*;


import java.io.*;
import java.math.BigInteger;


public class Main {
	
	static class Node{
		int node;
		Long time;
		
		Node(int node, Long time) {
			this.node=node;
			this.time=time;
		}
	}

	
    public static void main(String[] args)throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int n=Integer.parseInt(st.nextToken());
    	int m=Integer.parseInt(st.nextToken());
    	
    	int[] a=new int[n];
    	
    	st= new StringTokenizer(br.readLine());
    	
    	//시야 입력
    	for(int i=0;i<n;i++) {
    		a[i]=Integer.parseInt(st.nextToken());
    	}
    	a[n-1]=0;
    	
    	//거리 입력 받기
    	ArrayList<ArrayList<Node>> array= new ArrayList<>();
    	//array 그래프 n 만큼 늘리기
    	for(int i=0;i<n;i++) {
    		array.add(new ArrayList<Node>());
    		
    	}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Long c = Long.parseLong(st.nextToken());
		
			array.get(s).add(new Node(e,c));
			array.get(e).add(new Node(s,c));
		}
		
		PriorityQueue<Node> q=new PriorityQueue<Node>((o1,o2)->Long.compare(o1.time,o2.time)) ;
    	Long[] dist=new Long[n];
    	
    	for(int i=0;i<n;i++) {
    		dist[i]=Long.MAX_VALUE;
    	}
		
    	//시작 노드
		q.offer(new Node(0,0l));
		dist[0]=0l;
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			
			if(dist[now.node]<now.time) {
				continue;
			}
			
			//주변 노드 탐색하여 최단거리 구축
			
			for(int i=0;i<array.get(now.node).size();i++) {
				Node next=array.get(now.node).get(i);
				
				if(dist[next.node]>dist[now.node]+next.time ) {
					if(a[next.node]==0) {
					
						dist[next.node]=dist[now.node]+next.time;
						q.offer(new Node(next.node,dist[next.node]));
						
					}
				}
			}
			
			
		}
		
    	if(dist[n-1]==Long.MAX_VALUE) {
    		System.out.println(-1);
    	}else {
    		System.out.println(dist[n-1]);
    	}
    	
    	
    	
    	

    }

        

    
    

}
