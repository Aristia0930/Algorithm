
import java.util.*;
import java.io.*;

public class Main {
	static int[] p;
	static class Edge{
		int u,v,weight;
		
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
		
	}
	//find
	public static int find(int x) {
		if(p[x]==x) {
			return x;
		}else {
			return find(p[x]);
		}
	}
	
	//유니온
	public static void union(int x, int y ) {
		x=find(x);
		y=find(y);
		
		if(x<y) {
			p[x]=y;
		}else {
			p[y]=x;
		}
	}
	


    public static void main(String[] args) throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n =Integer.parseInt(st.nextToken());
    	int m =Integer.parseInt(st.nextToken());
    	
    	Queue<Edge> q=new PriorityQueue<>((a,b)-> a.weight-b.weight);
    	for(int i=0;i<m;i++) {
    		st=new StringTokenizer(br.readLine());
    		
        	int u =Integer.parseInt(st.nextToken());
        	int v =Integer.parseInt(st.nextToken());
        	int w =Integer.parseInt(st.nextToken());
        	
        	q.add(new Edge(u,v,w));
    		
    	}
    	

    	//부모 노드 값 초기화
    	p =new int[n+1];
    	for(int i=0;i<p.length;i++) {
    		p[i]=i;
    	}
    	
    	//가장큰 비용
    	int max_w=0;
    	//토탈 비용
    	int cost=0;
    	
    	//크루스칼 알고리즘
    	while(!q.isEmpty()) {
    		Edge e=q.poll();
    		
    		if(find(e.u)!=find(e.v)) {
    			union(e.u, e.v);
    			cost+=e.weight;
    			max_w=Math.max(max_w, e.weight);
    			
    		}
    	}
    	
    	System.out.println(cost-max_w);
    	
    }
}
