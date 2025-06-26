

import java.util.*;
import java.io.*;

public class Main {
	static Map<Long, Long> array=new HashMap<>();
	static class keyValue{
		long key;
		long value;
		
		keyValue(long x,long v){
			key=x;
			value=v;
		}
	}
	
	




    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	long n=Long.parseLong(st.nextToken());
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		long number=Long.parseLong(st.nextToken());
    		if(array.containsKey(number)) {
    			long a=array.get(number);
    			array.put(number,a+1);
    		}else {
    			array.put(number,1l);
    		}
    	}
    	
    	List<keyValue> arr=new ArrayList<>();
    	
    	for(long key:array.keySet()) {
    		arr.add(new keyValue(key, array.get(key)));
    	}
    	
    	Collections.sort(arr,(a,b)->{
    			if(a.value==b.value) {
    				return Long.compare(a.key, b.key);  
    			}
    			return Long.compare(b.value, a.value);
    			
    			});
    	
    	System.out.println(arr.get(0).key);
    	
    	
    	
    	

    	

    }
}
