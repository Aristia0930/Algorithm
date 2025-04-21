
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

    	
    	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(bf.readLine());
    	
    	int r = Integer.parseInt(st.nextToken());
    	int count = 0;

    	for (int i = 5; i <= r; i *= 5) {
    	    count += r / i;
    	}
    	System.out.println(count);
    	
    	

    			
    }
    

}
