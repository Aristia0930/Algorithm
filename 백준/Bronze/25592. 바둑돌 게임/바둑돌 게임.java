import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int now=1;
        int count=0;
        
        while(true) {
        	n=n-now;
        	count++;

        	
        	if(n<0) {
        	
	        	if(count%2==0) {
	        		System.out.println(0);

	        	}else {
	        		System.out.println(n*-1);
	        	}
	        	
	        	break;

        	}
        	now++;
        }
    }

}