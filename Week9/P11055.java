
import java.util.Scanner;


public class P11055{

    public static int max_increasing_sequence_sum(int N,int A[]){
        //배열 초기화 
        int[] dp = new int[N];

        for (int i = 0; i < N; i++){
            dp[i] = A[i];
        }

        for (int i = 1; i < N; i++){
            for (int j=0; j <i; j++){
                if (A[j] < A[i]){
                    dp[i] = Math.max(dp[i],dp[j]+ A[i]);
                }
            }
        }
        int MaxSum = 0;
        for (int i = 0; i < N; i++){
            MaxSum = Math.max(MaxSum,dp[i]);
        }

        return MaxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //배열의 크기 저장 
        int N = sc.nextInt();
        //배열 저장 
        int [] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        int result = max_increasing_sequence_sum(N, A);

        System.out.println(result);
    }
}