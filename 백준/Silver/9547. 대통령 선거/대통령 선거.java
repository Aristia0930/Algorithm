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
		
		int test= Integer.parseInt(br.readLine());
		for(int t=0; t<test;t++) {
			String[] cv=br.readLine().split(" ");
			int c=Integer.parseInt(cv[0]);
			int v=Integer.parseInt(cv[1]);
			int[][] arr=new int[v][c];
			for (int i=0;i<v;i++) {
				
				String[] array=br.readLine().split(" ");
				for(int j=0;j<c;j++) {
					arr[i][j]=Integer.parseInt(array[j]);
				}

				
			}
			int[] rank=new int[c+1];
	        int maxCandidate = -1, secondMaxCandidate = -1;
	        int maxVotes = 0, secondMaxVotes = 0;
			//1회차
	        
	        //과반수
	        int maj=v/2+1;
	        int[] firstRoundVotes = new int[c + 1]; // 후보 번호가 1부터 시작하므로 C+1 크기 배열 사용
	        for (int i = 0; i < v; i++) {
	            int firstChoice = arr[i][0];
	            firstRoundVotes[firstChoice]++;
	        }
	        for(int i=1; i<=c;i++) {
	        	if(firstRoundVotes[i]>maxVotes) {
	        		secondMaxVotes=maxVotes;
	        		secondMaxCandidate=maxCandidate;
	        		maxVotes=firstRoundVotes[i];
	        		maxCandidate=i;
	        	}
	        	else if(firstRoundVotes[i]>secondMaxVotes) {
	        		secondMaxCandidate=i;
	        		secondMaxVotes=firstRoundVotes[i];
	        	}
	        }
	        
	        if(maxVotes>=maj) {
	        	pw.println(maxCandidate+" 1");
	        }
	        else {
	        	//2차 투포 개시
	        	int[] secondRoundVotes = new int[c + 1];
	            for (int i = 0; i < v; i++) {
	                for (int j = 0; j < c; j++) {
	                	if(maxCandidate==arr[i][j] || secondMaxCandidate==arr[i][j]) {
	                		secondRoundVotes[arr[i][j]]++;
	                		break;
	                	}
	                }
	            }
	            int secondmax=0;
	            int candidate=-1;
	            for(int i=1;i<=c;i++) {
	            	if(secondRoundVotes[i]>secondmax) {
	            		secondmax=secondRoundVotes[i];
	            		candidate=i;
	            	}
	            }
	        	pw.println(candidate+" 2");
	        }

		
		}
	
		pw.flush();
		pw.close();
		br.close();

	
	}
}