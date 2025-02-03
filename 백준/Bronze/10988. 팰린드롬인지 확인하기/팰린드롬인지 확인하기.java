import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] arr=br.readLine().split("");
		String[] arr2=new String[arr.length];
		int count=0;
		for (int i=arr.length-1; i>=0;i--) {
			arr2[count]=arr[i];
			count++;
		}
		boolean check=true;
		for(int i=0;i<arr.length;i++) {
			if(!arr[i].equals(arr2[i])){
				check=false;
				break;
			}
		}

		if(check) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

}