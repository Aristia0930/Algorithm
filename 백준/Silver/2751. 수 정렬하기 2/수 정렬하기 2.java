

import java.util.*;
import java.io.*;


public class Main {
	
	//병합정렬
	static void mergeSort(int[] list,int left,int right) {
		//나누는 위치
		if(left<right) {
			int mid=(left+right)/2;
			
			//왼쪽 배열
			mergeSort(list, left, mid);
			mergeSort(list, mid+1, right);
			
			//분할 한 두 배열 합치기
			merge(list,left,mid,right);
			
		}
		else  {
			return;
		}
	}
	
	static void merge(int[] list, int left, int mid, int right) {
		

		//임시배열 크기
		int n1=mid-left+1;
		int n2=right-mid;
        
        // 임시 배열 생성
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // 데이터를 임시 배열로 복사
        for (int i = 0; i < n1; i++) {
            leftArr[i] = list[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = list[mid + 1 + j];
        }
        
        int i=0;
        int j=0;
        int k=left;
        
        //임시리스트 병합
        
        while(i<n1&& j<n2) {
        	if(leftArr[i]<=rightArr[j]) {
        		list[k]= leftArr[i];
        		i++;
        	}else {
        		list[k]= rightArr[j];
        		j++;
        	}
        	
        	k++;
        	
        }
        
        // 남은 요소들 복사
        while (i < n1) {
        	list[k]= leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
        	list[k]= rightArr[j];
            j++;
            k++;
        }
    
 
	}

	

    public static void main(String[] args) throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int n= Integer.parseInt(st.nextToken());
    	int[] array=new int[n];
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		array[i]=(Integer.parseInt(st.nextToken()));
    	}
    	
    	//정렬
    	mergeSort(array,0,n-1);
    	
    	for(int i=0;i<n;i++) {
    		System.out.println(array[i]);
    	}

    	


    }
}
