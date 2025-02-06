import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int time=0;
		HashMap<String, Integer> day=new HashMap<>();
		day.put("Mon", 0);
		day.put("Tue", 1);
		day.put("Wed", 2);
		day.put("Thu", 3);
		day.put("Fri", 4);
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String day1=st.nextToken();
			int h1=Integer.parseInt(st.nextToken());
			String day2=st.nextToken();
			int h2=Integer.parseInt(st.nextToken());
			
			if(day1.endsWith(day2)) {
				time+=(h2-h1);
			}
			else {
				int count=day.get(day2)-day.get(day1);
				time+=(24*count-h1+h2);
				
			}
			
		}
		
		if(t-time>48) {
			System.out.println(-1);
		}
		else {
			if(t-time<=0) {
				System.out.println(0);
			}
			else {
			System.out.println(t-time);
		}

    }
}
}