

import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int node;
        int cost;
        
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int from_f = Integer.parseInt(st.nextToken());
        int to_f = Integer.parseInt(st.nextToken());
        
        int[] dist1 = dijkstra(n, graph, 1);
        int[] dist2 = dijkstra(n, graph, from_f);
        int[] dist3 = dijkstra(n, graph, to_f);
        
        int rs1 = (dist1[from_f] == Integer.MAX_VALUE || dist2[to_f] == Integer.MAX_VALUE || dist3[n] == Integer.MAX_VALUE) 
        	    ? Integer.MAX_VALUE 
        	    : dist1[from_f] + dist2[to_f] + dist3[n];

        int rs2 = (dist1[to_f] == Integer.MAX_VALUE || dist2[n] == Integer.MAX_VALUE || dist3[from_f] == Integer.MAX_VALUE) 
        	    ? Integer.MAX_VALUE 
        	    : dist1[to_f] + dist2[n] + dist3[from_f];
        int rs = Math.min(rs1, rs2);
        if (rs==Integer.MAX_VALUE ) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(rs);
        }

    }
    
    public static int[] dijkstra(int n, List<List<Node>> graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        q.offer(new Node(start, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (dist[now.node] < now.cost) continue;
            
            for (Node next : graph.get(now.node)) {
                if (dist[next.node] > dist[now.node] + next.cost) {
                    dist[next.node] = dist[now.node] + next.cost;
                    q.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }
}
