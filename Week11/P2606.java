import java.util.*;

public class P2606{

    //그래프 저장 2차원 배열 
    static List<List<Integer>> graph;
    static boolean[] visited_dfs;
    static int count=0;

    //바이러스 감염 컴퓨터 개수 찾기 -> dfs로 
    public static void worm_dfs(int v){

        visited_dfs[v] = true;

        for (int i: graph.get(v)) {
            if(visited_dfs[i] == false){
                count++;
                worm_dfs(i);
            }
            
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n은 컴퓨터 개수, m은 네트워크 개수 
        int n = sc.nextInt();
        int m = sc.nextInt();

        //방문 여부 기록 배열 
        visited_dfs = new boolean[n+1];

        //null인 상태에서 에러가 발생하는 것 방지 하기 위해! 
        graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            //양방향 연결 
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        worm_dfs(1);
        System.out.println(count);

    }
}