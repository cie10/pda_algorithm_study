
import java.util.*;

public class P2178{
    //x, y 좌표와 이동거리 저장 Class
    static class Node{
        int x, y, dist;

        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int shortest_path(int n, int m, int [][] grid){

        //상, 하, 좌, 우 
        //배열 한번에 초기화 할때 중괄호 사용
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //방문 여부 기록 배열 
        boolean [][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        //큐와 방문여뷰 배열에 시작 값 넣기 
        queue.offer(new Node(0,0,1));

        visited[0][0] = true;

        while(!queue.isEmpty()){

            //현재 노드 꺼내기 
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;

            //정착지에 도달했을 경우 
            if(x == n-1 && y == m-1){
                return dist;
            }
            //상,하,좌,우 탐색
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위 안에 있는 경우    
                if (0 <= nx && nx < n && 0 <= ny && ny < m){
                    //방문한 적이 없고, grid 값이 1인 경우 
                    if(visited[nx][ny] == false && grid[nx][ny]==1){
                        //만족할 경우 큐에 추가 
                        queue.offer(new Node(nx, ny, dist+1));
                        //방문 여부 기록
                        visited[nx][ny] = true;
                    }

                }

            }

        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 행, M 열 저장
        int N = sc.nextInt();
        int M = sc.nextInt();

        //gri 저장 
        int [][] grid = new int[N][M];

        for (int i = 0; i < N; i++){
            String row = sc.next(); //공백 전까지 한 줄 입력받기 
            for(int j = 0; j <M; j++){
                grid[i][j] = row.charAt(j) -'0';//문자 정수로 변환
            }
        }

        int result = shortest_path(N, M, grid);
        System.out.println(result);
    }
}