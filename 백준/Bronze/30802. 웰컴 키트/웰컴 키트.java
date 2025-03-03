

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] array = new int[6];
		int index=0;
		while(st.countTokens()!=0) {
			array[index]= Integer.parseInt(st.nextToken());
			index++;
		}
		int[] rs= new int[2];
		index=0;
		st = new StringTokenizer(br.readLine());
		while(st.countTokens()!=0) {
			rs[index]= Integer.parseInt(st.nextToken());
			index++;
		}
		
		int t_count=0;
		for(int i : array) {
			t_count+=i/rs[0];
			if((i/rs[0])>0 && i%rs[0]>0) {
				t_count++;
			}
			else if (i%rs[0]>0) {
				t_count++;
			}
		}
		int p_count=n/rs[1];
		int p_one_count=n%rs[1];
		
		System.out.println(t_count);
		System.out.println(p_count+" "+p_one_count);

		

	}

}
