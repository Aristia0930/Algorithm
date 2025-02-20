import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


	
	    public static void main(String[] args) throws NumberFormatException, IOException {
	    	
	    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    	StringBuilder output = new StringBuilder();
	    	int n= Integer.parseInt(br.readLine());
	    	
	    	ArrayList<Integer> array=new ArrayList<Integer>();
	    	
	    	for (int i=0;i<n;i++) {
	    		StringTokenizer st=new StringTokenizer(br.readLine());
	    		String a=st.nextToken();
	    		int b=0;
	    		if(st.countTokens()!=0) {
	    			b=Integer.parseInt(st.nextToken());
	    		}
	    		if (a.equals("add")) {
	    			if (!array.contains(b)) {
	    				array.add(b);
	    			}
	    		}
	    		else if(a.equals("check")) {
	    			if(array.contains(b)){
	    				output.append(1).append("\n");
	    			}
	    			else {
	    				output.append(0).append("\n");
	    			}
	    		
	    		
	    		
	    		}
	    		else if (a.equals("remove") && array.contains(b)) {
	    			array.remove(Integer.valueOf(b));
	    		}
	    		
	    		else if (a.equals("toggle") ) {
	    			if(array.contains(b)) {
	    				array.remove(Integer.valueOf(b));
	    			}
	    			else {
	    				array.add(b);
	    			}
	    		}
	    		else if(a.equals("all")) {
	    	        array.clear();

	    	        // S를 {1, 2, ..., 20}으로 다시 초기화
	    	        for (int j = 1; j <= 20; j++) {
	    	            array.add(j);
	    	        
	    		}
	    	        
	    			

	    		}
	    		else{
	    			array.clear();
	    		}
	    	
	    	
	    	
	    }
	    	System.out.print(output.toString());
	    }
}