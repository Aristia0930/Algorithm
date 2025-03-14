
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String n = sc.next();
    	Long ans=(long) n.length();
    	Long rs=0l;
    	
    	


    	Long count=0l;
    	String s="9";
    	if (ans==1) {
    		rs=Long.parseLong(n);
    	}
    	else {
    		rs=(long) (Long.parseLong(n)-Math.pow(10, ans-1))+1;
    	}

    	for (int k =0; k<ans;k++) {
    		if(k==0) {
    			count=ans*rs;
    		}
    		else {
    			count+=k*Long.parseLong(s);
    			s+="0";
    		}
    	}

    	System.out.println(count);
    	

    }
}
