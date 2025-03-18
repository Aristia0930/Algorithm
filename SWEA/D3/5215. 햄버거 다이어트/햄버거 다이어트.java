
import java.util.*;
import java.io.*;

public class Solution {
    static class value{
        int s;
        int c;

        value(int s, int c){
            this.s=s;
            this.c=c;
        }
    }
    static int ans;

    static void bki(int n,int rs,int ca,int count,value[] arr,int l){
        if (l<ca){
            return;
        }
        
        if (count==n){
            if (ans<rs){
                ans=rs;
                return;
            }
        }
        else{
            bki(n,rs+arr[count].s,ca+arr[count].c,count+1,arr,l);
            bki(n,rs,ca,count+1,arr,l);
        }
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t=Integer.parseInt( st.nextToken());
        for(int test=1;test<t+1;test++) {
        	
        
        
        st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt( st.nextToken());
        int l=Integer.parseInt( st.nextToken());
        value[] arr = new value[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt( st.nextToken());
            int c=Integer.parseInt( st.nextToken());
            arr[i]=new value(s,c);
        }

        ans = 0;
        bki(n,0,0,0,arr,l);
        System.out.printf("#%d ",test);
        System.out.println(ans);
        
    }
    }
}
