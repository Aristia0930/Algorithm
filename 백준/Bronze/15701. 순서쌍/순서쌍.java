import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=1; i<(int)Math.sqrt(n)+1;i++) {
			if((n/i)*i==n) {
				count++;
				if(i!=n/i) {
					count++;
				}


			}
		}
		System.out.println(count);

	
		
		
}
}
