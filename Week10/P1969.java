
import java.util.Scanner;


public class P1969{

    //변수 저장 클래스 
    static class Result{
        String dna;
        int hamming_distance;

        public Result(String dna, int hamming_distance){
            this.dna = dna;
            this.hamming_distance = hamming_distance;
        }

    }
    public static Result get_hamming_distance(int N, int M, char dna_list[][]){

        // 결과 저장 배열
        StringBuilder result = new StringBuilder();
        int hamming_distance = 0;

        for(int i = 0; i <M; i++){

            // 빈도수 저장 베열 초기화 
            int [] frequency = new int[26]; //A~Z에 해당하는 빈도수 

            for (int j = 0; j <N; j++){
                char c = dna_list[j][i];
                frequency[c-'A']++; //문자에 해당하는 숫자에 빈도수 저장 (문자를 숫자로 변환)
            }
            char most_common_char = 'A';
            int max_count = 0;

            //가장 빈도수 높은 문자를 저장 후, 사전순! 
            for (int k = 0; k < 26; k++){
                // k+'A' -> 숫자를 문자로 변환! 
                if( frequency[k] > max_count || ((frequency[k] == max_count) && k +'A' < most_common_char)){
                    most_common_char = (char)(k+'A');
                    max_count = frequency[k];
                }
            }
            //가장 빈도수 높고, 사전순으로 앞에 있는 문자 결과 문자열에 추가!
            result.append(most_common_char);
            
            for (int j = 0; j < N; j++) {
                if(dna_list[j][i] != most_common_char){
                    hamming_distance += 1;
                }
            }

        }
        return new Result(result.toString(), hamming_distance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); 
        sc.nextLine(); // 버퍼 비우기

        // dna 리스트 
        char [][] dna_list = new char[N][M];

        for (int i = 0; i < N; i++){
            String row = sc.nextLine();
            dna_list[i] = row.toCharArray(); //문자열을 문자배열로 변경해서 저장

        }
        Result result = get_hamming_distance(N, M, dna_list);

        System.out.println(result.dna);
        System.out.println(result.hamming_distance);
    }
}