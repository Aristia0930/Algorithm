
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	
    	for (int t=0; t<n;t++) {
    		st= new StringTokenizer(br.readLine());
    		int m = Integer.parseInt(st.nextToken());
    		int[] left=new int[m];
    		int[] right=new int[m];
    		st= new StringTokenizer(br.readLine());
    		for (int i =0;i<m;i++) {
    			left[i]=Integer.parseInt(st.nextToken());
    		}
    		st= new StringTokenizer(br.readLine());
    		for (int i =0;i<m;i++) {
    			right[i]=Integer.parseInt(st.nextToken());
    		}
    		int ans=0;
    		int index=0;
    		while(index<=m-1) {
    			int now=left[index];
        		int checkNum=-1;
    			for (int i =index+1;i<m;i++) {
        			if(now+500==left[i]) {
        				checkNum=left[i];
        			}
        		}
    			
    			boolean check=false;
    			if(checkNum>0) {
        			for (int i =0;i<m;i++) {
            			if(checkNum-1000==right[i]) {
            				check=true;
            			}
            		}
        			if(!check) {
        				ans++;
        			}
    			}
    			
    	
    			index++;
    		}
    		
    		
    		System.out.println(ans);
    	}


    }
    

}
