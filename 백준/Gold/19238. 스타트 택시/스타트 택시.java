import java.io.*;
import java.util.*;
class Index implements Comparable<Index>{
    int x;
    int y;
    int num;
    public Index(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Index index) {
        int tmp = Integer.compare(this.num, index.num);
        if(tmp != 0){
            return tmp;
        }
        tmp = Integer.compare(this.x, index.x);
        if(tmp != 0){
            return tmp;
        }
        return Integer.compare(this.y, index.y);
    }
}
public class Main {
    static int n;
    static int m;
    static int gas;
    static int taxi_x;
    static int taxi_y;
    static int [][] a;
    static boolean [][] visited;
    static boolean in_range(int x, int y){
        if(x > 0 && x <= n && y > 0 && y <= n){
            return true;
        }
        return false;
    }
    static int [] dx = {-1, 0, 1, 0}; // 위 왼쪽 아래 오른쪽
    static int [] dy = {0, -1, 0, 1};

    static Index BFS(int r, int c){ // 가장 가까운 손님 찾기
        visited = new boolean[n + 1][n + 1];
        queue = new PriorityQueue<>();
        queue.add(new Index(r, c, 0));
        while(!queue.isEmpty()){
            Index index = queue.remove();
            if(a[index.x][index.y] == 2){
                a[index.x][index.y] = 0;
                return index;
            }
            for(int k = 0;k<4;k++){
                int x = index.x + dx[k];
                int y = index.y + dy[k];
                if(in_range(x, y) && !visited[x][y] && a[x][y] != 1){
                    queue.add(new Index(x, y, index.num + 1));
                    visited[x][y] = true;
                    if(a[x][y] == 2){

                    }
                }
            }
        }
        return new Index(-1, -1, -1);
    }
    static Index BFS2(int r, int c, int get_r, int get_c){
    	visited = new boolean[n + 1][n + 1];
        ArrayDeque<Index> deque = new ArrayDeque<>();
        deque.add(new Index(r, c, 0));
        while(!deque.isEmpty()){
            Index index = deque.removeFirst();
            if(index.x == get_r && index.y == get_c){
                return index;
            }
            for(int k = 0;k<4;k++){
                int x = index.x + dx[k];
                int y = index.y + dy[k];
                if(in_range(x, y) && !visited[x][y] && a[x][y] != 1){
                    deque.addLast(new Index(x, y, index.num + 1));
                    visited[x][y] = true;
                }
            }
        }
        return new Index(-1, -1, -1);
    }
    static PriorityQueue<Index> queue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Index> map = new HashMap<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        taxi_x = Integer.parseInt(st.nextToken());
        taxi_y = Integer.parseInt(st.nextToken());
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int people_x = Integer.parseInt(st.nextToken());
            int people_y = Integer.parseInt(st.nextToken());
            int flag_x = Integer.parseInt(st.nextToken());
            int flag_y = Integer.parseInt(st.nextToken());
            int bit = people_x << 5 | people_y;
            a[people_x][people_y] = 2;
            map.put(bit, new Index(flag_x, flag_y, 0));
        }
        for(int i = 0;i<m;i++){
            Index index = BFS(taxi_x, taxi_y);
            int start_gas = index.num;
            taxi_x = index.x;
            taxi_y = index.y;
           
            if(start_gas != -1){
            	int bit = taxi_x << 5 | taxi_y;
                Index get_index = map.get(bit);
                index = BFS2(taxi_x, taxi_y, get_index.x, get_index.y);
                int end_gas = index.num;
                taxi_x = index.x;
                taxi_y = index.y;
                if(end_gas == -1){
                    System.out.println("-1");
                    return;
                }
                if(gas >= start_gas + end_gas){
                    gas = gas - start_gas + end_gas;
                }else{
                    System.out.println("-1");
                    return;
                }
            }else{
                System.out.println("-1");
                return;
            }
        }
        System.out.println(gas);
    }
}