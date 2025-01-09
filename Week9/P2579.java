
import java.util.Scanner;



public class P2579{

    public static int get_max_score(int n, int stair[]){
        
        if(n == 1){
            return stair[0];
        }
        else if (n == 2){
            return stair[0] + stair[1];
        }
        else{
            int [] dp = new int[n];

            dp[0] = stair[0];

            dp[1] = stair[0] + stair[1];

            dp[2] = Math.max(stair[2]+stair[1] , stair[2] + stair[0]);

            for (int i = 3; i < n; i++){
                dp[i] = Math.max(dp[i-3] + stair[i-1]+ stair[i], dp[i-2] + stair[i]);

            }

            return dp[n-1];

        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] stair = new int[n];

        for (int i = 0; i < n; i++){
            stair[i] = sc.nextInt();
        }
        int result = get_max_score(n, stair);

        System.out.println(result);
    }
}