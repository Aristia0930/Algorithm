import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n=Integer.parseInt(br.readLine());
		List<Long> arr=new ArrayList<Long>();
		arr.add((long) 1);
		arr.add((long) 1);
		arr.add((long) 2);
		
		for(int i=3; i<=n;i++) {
			int v1=i/2;
			int v2=i%2;
			int index=arr.size()-1;
			Long sum=0L;
			for(int j=0; j<v1;j++) {
				sum+=2*(arr.get(index)*arr.get(j));
				index--;
			}
			if(v2!=0) {
				sum+=arr.get(index)*arr.get(index);
			}
			arr.add((long) sum);
		}
		pw.println(arr.get(n));
	
		pw.flush();
		pw.close();
		br.close();

	}

}