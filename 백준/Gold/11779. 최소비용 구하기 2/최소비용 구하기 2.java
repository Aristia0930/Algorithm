

import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<ArrayList<Node>> graph;
	
	static class Node{
		int idx;
		int cost;
		
		
		Node(int idx,int cost){
			this.idx=idx;
			this.cost=cost;
		}
	}


    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	//도시수
    	int n=Integer.parseInt(st.nextToken());
    	
    	//버스수
    	st=new StringTokenizer(br.readLine());
    	int m =Integer.parseInt(st.nextToken());
    	
    	//도시그래프
    	graph=new ArrayList<ArrayList<Node>>();
    	for(int i=0;i<=n;i++) {
    		graph.add(new ArrayList<Node>());
    	}
    	
    	//버스 정보
    	for(int i=0;i<m;i++) {
    		st=new StringTokenizer(br.readLine());
    		int start=Integer.parseInt(st.nextToken());
    		int end=Integer.parseInt(st.nextToken());
    		int cost=Integer.parseInt(st.nextToken());
    		graph.get(start).add(new Node(end,cost));
    		
    	}
    	
    	//거리테이블
    	int[] dist=new int[n+1];
    	int[] dist2=new int[n+1];
    	for(int i=0;i<=n;i++) {
    		dist[i]=Integer.MAX_VALUE;
    	}
    	
    	//시작 도착 지점
    	st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		
		//시작 거리 초기화
		dist[start]=0;
		
		//프라이머리 큐 
		PriorityQueue<Node> q=new PriorityQueue<>((o1,o2)->(o1.cost-o2.cost));
		q.offer(new Node(start,0));
		
		while(!q.isEmpty()) {
			Node now  =q.poll();
			
			
			if(dist[now.idx]<now.cost) {
				continue;
			}
			//주변 탐색
			for(int i =0; i<graph.get(now.idx).size();i++) {
				Node next=graph.get(now.idx).get(i);
				
				if(now.cost+next.cost<dist[next.idx]) {
					dist[next.idx]=now.cost+next.cost;
					q.offer(new Node(next.idx,now.cost+next.cost));
				    dist2[next.idx] = now.idx; // 올바른 위치에서만 갱신!
				}
				
			}
			
		}
		
		System.out.println(dist[end]);
		int count=0;
		int value=-1;
		String ans="";
		while(value!=0) {
			ans=" "+ans;
			ans=end+ans;
			value=dist2[end];
			end=value;
			count++;
			
		}
		System.out.println(count);
		System.out.println(ans);
    	
    	
    	
    }

    

}
