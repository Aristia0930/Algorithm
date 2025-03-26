import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	Long n = Long.parseLong(st.nextToken());
    	int b= Integer.parseInt(st.nextToken());
    	Long index=1l;
    	Long count=1l;
    	boolean check=false;
    	while (b>=0) {
    		if(n<=count) {
    			check=true;
    			break;
    		}
    		b--;
    		index*=2;
    		count+=index;
    	}
    	if(check) {
    		System.out.println("yes");
    	}
    	else {
    		System.out.println("no");
    	}
    	
    	


    }
    

}
