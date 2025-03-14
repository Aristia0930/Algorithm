

import java.io.*;
import java.util.*;

public class Solution {
	static class Node{
		int x;
		Long cost;
		
		Node(int x,Long cost){
			this.x=x;
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
			Long[] idx=new Long[n];
			Long[] idy=new Long[n];
			
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				idx[i]= Long.parseLong(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				idy[i]=Long.parseLong(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			double e= Double.parseDouble(st.nextToken());
			
			double cost=0;
			
			PriorityQueue<Node> q=new PriorityQueue<Node>(Comparator.comparingLong(n1->n1.cost));
			boolean[] v= new boolean[n];
			
			q.offer(new Node(0,(long) 0));
	
			
			while (!q.isEmpty()) {
			
				Node node =q.poll();
				if (v[node.x]) {
					continue;
				}
				v[node.x]=true;
				cost+=node.cost;
				
				for (int i=0;i<n;i++) {
	
					if(!v[i]) {
						
					
						Long dix=idx[node.x]-idx[i];
						Long diy=idy[node.x]-idy[i];
						
						Long newCost=(dix*dix)+(diy*diy);
						q.offer(new Node(i,newCost));
					}
					
				}
				
				
				
			}
			System.out.printf("#%d ",test);
			System.out.println(Math.round(cost * e));
			
			
		}
		

	}

}
