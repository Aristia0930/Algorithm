
import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int x;
		int y;
		
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static Node lnode;
	static Node rnode;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		 Map<String, Node> keyboardMap = new HashMap<>();
		 Map<String, Node> keyboardMap2 = new HashMap<>();
        
		 keyboardMap.put("q", new Node(1, 1));
		 keyboardMap.put("w", new Node(1, 2));
		 keyboardMap.put("e", new Node(1, 3));
		 keyboardMap.put("r", new Node(1, 4));
		 keyboardMap.put("t", new Node(1, 5));
		 keyboardMap.put("a", new Node(2, 1));
		 keyboardMap.put("s", new Node(2, 2));
		 keyboardMap.put("d", new Node(2, 3));
		 keyboardMap.put("f", new Node(2, 4));
		 keyboardMap.put("g", new Node(2, 5));
		 keyboardMap.put("z", new Node(3, 1));
		 keyboardMap.put("x", new Node(3, 2));
		 keyboardMap.put("c", new Node(3, 3));
		 keyboardMap.put("v", new Node(3, 4));

		 keyboardMap2.put("y", new Node(1, 6));
		 keyboardMap2.put("u", new Node(1, 7));
		 keyboardMap2.put("i", new Node(1, 8));
		 keyboardMap2.put("o", new Node(1, 9));
		 keyboardMap2.put("p", new Node(1, 10));
		 keyboardMap2.put("h", new Node(2, 6));
		 keyboardMap2.put("j", new Node(2, 7));
		 keyboardMap2.put("k", new Node(2, 8));
		 keyboardMap2.put("l", new Node(2, 9));
		 keyboardMap2.put("b", new Node(3, 5));
		 keyboardMap2.put("n", new Node(3, 6));
		 keyboardMap2.put("m", new Node(3, 7));
		 
		 
            String sl=st.nextToken();
            
            
        	if(keyboardMap.containsKey(sl)) {
        		lnode=keyboardMap.get(sl);
        	}
        	
        	if(keyboardMap2.containsKey(sl)) {
        		lnode=keyboardMap2.get(sl);
        		
        	}
        	
            String sr=st.nextToken();
        	if(keyboardMap.containsKey(sr)) {
        		rnode=keyboardMap.get(sr);
        	}
        	
        	if(keyboardMap2.containsKey(sr)) {
        		 rnode=keyboardMap2.get(sr);
        		
        	}
            
            int ans =0;

            
            String word=br.readLine();
            
            for(int i=0;i<word.length();i++) {
            	String value=String.valueOf(word.charAt(i));
            	
            	if(keyboardMap.containsKey(value)) {
            		Node now =keyboardMap.get(value);
            		int rs=Math.abs(lnode.x-now.x)+Math.abs(lnode.y-now.y);
            		ans+=rs+1;
            		lnode=now;
            	}
            	
            	if(keyboardMap2.containsKey(value)) {
            		Node now =keyboardMap2.get(value);
            		int rs=Math.abs(rnode.x-now.x)+Math.abs(rnode.y-now.y);
            		ans+=rs+1;
            		rnode=now;
            		
            	}
            }
            
            System.out.println(ans);
		

	}

}
