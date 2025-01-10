
import java.util.Scanner;

public class P14916{

    public static int change(int n){
        // 동전 개수 저장 변수 
        int cnt = 0;

        while(n > 0){

            if(n % 5 == 0){
                cnt += n/5;
                return cnt;
            }
            else{
                n -= 2;
                cnt += 1;
            }
        }
        if(n < 0){
            return -1;
        }
        else{
            return cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = change(n);
        System.out.println(result);
    }
}