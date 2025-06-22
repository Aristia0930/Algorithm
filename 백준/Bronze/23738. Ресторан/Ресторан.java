import java.util.*;
import java.io.*;

public class Main {
	static Map<String, String> code=new HashMap<>();
	




    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	String[] word=st.nextToken().split("");
    	code.put("A", "a");
    	code.put("K", "k");
    	code.put("M", "m");
    	code.put("O", "o");
    	code.put("T", "t");
    	
    	code.put("B", "v");
    	code.put("E", "ye");
    	code.put("H", "n");
    	code.put("P", "r");
    	
    	code.put("C", "s");
    	code.put("Y", "u");
    	code.put("X", "h");
    	
    	
    	String ans="";
    	
    	for(String a:word) {
    		ans+=code.get(a);
    	}
    	System.out.println(ans);
    	

    }
}
