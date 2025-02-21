import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static int[] dx = {-1, 1, 0, 0,1,1,-1,-1}; // 상하좌우
    static int[] dy = {0, 0, -1, 1,1,-1,1,-1};

    public static void bfs(int x,int y,int[][]graph,int n){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x, y});
        graph[x][y]=-3;

        while (!q.isEmpty()){
            int[] now=q.poll();
            int xi=now[0];
            int yi=now[1];
            for (int i = 0; i < 8; i++) {
                int nx = xi + dx[i];
                int ny = yi + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n &&graph[nx][ny]>=0) {
                    if(graph[nx][ny]==0){
                        q.offer(new int[]{nx,ny});
                    }
                    graph[nx][ny]=-3;

                }


            }
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        for (int t=1;t<=T;t++){
            int n=sc.nextInt();
            sc.nextLine(); // 개행문자 처리
            char[][] array = new char[n][];

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine(); // 한 줄씩 입력받음
                array[i] = line.toCharArray(); // 문자열을 char 배열로 변환
            }
            int [][] graph=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(array[i][j]=='.'){

                        graph[i][j]=0;
                        for(int k=0;k<8;k++){

                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n && array[nx][ny]=='*') {
                                graph[i][j]+=1;

                            }
                        }


                    }else{
                        graph[i][j]=-1;
                    }

                }

            }

            int count=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][j]==0){
                        count+=1;
                        //bfs 실행하여 숫자인 자기 주변 숫자인경우 -2로 만들기 하고 이거 할대마다 카운트
                        bfs(i,j,graph,n);


                    }

                }

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][j]>0){
                        count+=1;


                    }

                }

            }
            System.out.printf("#%d %d",t,count);
            System.out.println();


//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(graph[i][j] == -1 ? "*" : graph[i][j]);
//                }
//                System.out.println();
//            }





        }
    }
}