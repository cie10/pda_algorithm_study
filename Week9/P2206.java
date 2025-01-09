import java.util.*;

public class P2206{
    
    static class Node{

        int x, y , dist, wall_broken;

        Node(int x, int y, int dist, int wall_broken){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall_broken = wall_broken;
        }
    }

    //최단 거리를 반환하는 함수 
    public static int ShortestPathwithWall(int n, int m, int[][] grid){

        // 상, 하, 좌, 우
        int[] dx = {-1, 1 , 0, 0}; 
        int[] dy = {0, 0, -1, 1};

        //방문 여부 초기화 (2는 벽을 부수고 이동했는 지 여부 표시)
        boolean[][][] visited = new boolean[n][m][2]; 
        //큐 초기화 해야지.... 
        Queue<Node> queue = new LinkedList<>();
        //시작점 저장 
        queue.offer(new Node(0,0,1,0));
        //첫 좌표 방문여부 기록 -> 첫좌표와 목적지 좌표는 0! 
        visited[0][0][0] = true;

        //큐에 값이 없을 때까지 루프
        while(!queue.isEmpty()){
            
            //노드 꺼내기 
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;
            int wall_broken = current.wall_broken;

            //목적지에 도달했을 경우 
            if(x == n-1 && y == m-1){
                return dist;
            }

            //네가지 방향을 탐색 
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 그리드 범위에서 넘어가지 않을 경우에만 
                if(0 <= nx && nx < n && 0 <= ny && ny < m){

                    //벽이 없는 경우에 가본적이 없는 경우 
                    if(grid[nx][ny] == 0 && visited[nx][ny][wall_broken]==false){
                        //방문 여부 기록 
                        visited[nx][ny][wall_broken] = true;
                        queue.offer(new Node(nx, ny, dist+1, wall_broken));
                    }
                    //벽이 있는 경우에 가본 적 없는 경우 
                    if(grid[nx][ny] == 1 && wall_broken == 0 && visited[nx][ny][1]==false){
                        //방문 여부 기록 
                        visited[nx][ny][1] = true;
                        queue.offer(new Node(nx, ny, dist+1, 1));
                    }
                }
            }  
        }
        //목적지에 도달하지 못할 경우 
        return -1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] grid = new int[n][m];
        for (int i = 0; i < n; i ++){
            String row = sc.next();

            for (int j = 0; j < m; j++){
                grid[i][j] = row.charAt(j)-'0';               
            }
        }

        int result = ShortestPathwithWall(n, m, grid);
        System.out.println(result);

        sc.close();
    }
}