import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		Character c;
		long count;
		
		Node(Character c,long count){
			this.c=c;
			this.count=count;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
	


		
		int n=Integer.parseInt(st.nextToken());
        String[] numbers = new String[n];
        boolean[] leading = new boolean[10]; 
        long[] weight = new long[10];
        ArrayList<Character> ch=new ArrayList<Character>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            numbers[i] = s;
            leading[s.charAt(0) - 'A'] = true; //앞자리 체크

            int len = s.length();
            for (int j = 0; j < len; j++) {
                int idx = s.charAt(j) - 'A';
                if(!ch.contains(s.charAt(j))) {
                	ch.add(s.charAt(j));
                }
                weight[idx] += (long) Math.pow(10, len - j - 1); 
            }
        }

  
        ArrayList<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            if (weight[i] > 0) {
                nodes.add(new Node((char) (i + 'A'), weight[i]));
            }
        }
        
        Collections.sort(nodes, (o1, o2) -> Long.compare(o2.count, o1.count));
        
        
        //현재 여기가 문제인데,.. 앞자리가 가아니면 가장 낮은 수로 배정해서 그런듯
        if(ch.size()==10) {
        int idx=-1;
        for(int i=nodes.size()-1;i>-1;i--) {
        	char c=nodes.get(i).c;
        	if(!leading[c-'A']) {
        		idx=i;
        		break;
        		
        	}

        	
        }
        if(idx!=-1) {
            Node zeroNode = nodes.remove(idx);
            nodes.add(zeroNode);
     
        }
        }
        
        //수자배정
        HashMap<Character, Long> map=new HashMap<Character, Long>();
		int k=9;
		for(Node node:nodes) {
			node.count=k;
			k--;
			map.put(node.c, node.count);
			}
        
		Long ans=0l;
		for(int i=0;i<n;i++) {
			String s=numbers[i];
			String a="";
			for(int j=s.length()-1;j>=0;j--) {
				Character c=s.charAt(j);
				
				a=map.get(c)+a;
				
				
			}
			ans+=Long.parseLong(a);
			
			
			
		}
		
		System.out.println(ans);

		

	}

}
