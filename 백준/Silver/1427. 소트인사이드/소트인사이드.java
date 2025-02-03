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
		int size=arr.length;
		Integer[] array=new Integer[size];
		for(int i=0;i<size;i++) {
			array[i]=Integer.parseInt(arr[i]);
			
		}
		Arrays.sort(array,Collections.reverseOrder());
		for(int i:array) {
			System.out.print(i);
		}
	}

}