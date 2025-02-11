import java.util.*;

public class P1260{

    static List<List<Integer>> graph;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;

    public static void dfs(int v){

        visited_dfs[v] = true;
        System.out.print(v + " ");

        //해당 노드에 인접한 노드들 번호 작은 순서대로 정렬
        Collections.sort(graph.get(v));
        for (int neighber: graph.get(v)) {

         if(visited_dfs[neighber]== false){
            dfs(neighber);
         }   
        }

    }
    public static void bfs(int start){
        //큐 초기화 
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited_bfs[start]=true;

        while(!queue.isEmpty()){
            int v = queue.poll(); 
            System.out.print(v+" ");
            Collections.sort(graph.get(v));

            for(int neighbor: graph.get(v)){
                
                if(visited_bfs[neighbor]==false){
                    queue.add(neighbor);
                    visited_bfs[neighbor] = true;
                }
            }
            
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // n은 노드 개수, m은 간선개수, v는 탐색 시작할 정점번호
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        //그래프 저장 
        graph = new ArrayList<>();

        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        // 방문 여부 기록 배열 
        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];

        for(int i = 0; i <m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 그래프 양방향 연결 
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(v);
        System.out.println();
        bfs(v);
    }


}



