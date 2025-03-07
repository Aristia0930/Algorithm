

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word=br.readLine();
		int n = word.length();
		int r=0;
		int c=0;
		for (int i=1; i<n+1;i++) {
			if(n%i==0) {
				if(r<i && (n/i)>=i) {
					r=i;
					c=n/i;
				}
			}
		}
		StringBuilder str=new StringBuilder();
		
		char[][] array=new char[r][c];
		int index=0;
		for (int i=0; i<c; i++) {
			for (int j=0; j<r; j++) {
				array[j][i]=word.charAt(index++);
			}
		}
		
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				str.append(array[i][j]);
			}
		}
		
		System.out.println(str);
		
		

	}

}
