import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    static int N, M;
    static int[][] city;
    //집 저장
    static List<int[]> houses = new ArrayList<>();
    //치킨집 저장 
    static List<int[]> chickenShops = new ArrayList<>();
    static int minCityDistance = Integer.MAX_VALUE;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력 받기 
        N = sc.nextInt();
        M = sc.nextInt();
        city = new int[N][N];

        for(int i = 0; i < N; i++){
            for (int j=0; j < N; j++){
                city[i][j] = sc.nextInt();

                if(city[i][j] == 1){
                    houses.add(new int[]{i,j});
                }else if (city[i][j] == 2){
                    chickenShops.add(new int[]{i,j});

                }

            }
        }

        combination(new ArrayList<>(), 0);
        System.out.println(minCityDistance);


    }


    //조합 생성 및 치킨 거리 계산 
    private static void combination (List<int[]> selected, int start){

        //선택된 치킨집의 개수가 m개일 때 계산 
        if(selected.size() == M){
            //최소값 업데이트 
            minCityDistance = Math.min(minCityDistance, calculateCityDistance(selected));
            return;
        }

        //치킨집 한개씩 늘려가면서 선택하기 
        for (int i = start; i < chickenShops.size(); i++){
            selected.add(chickenShops.get(i));
            combination(selected, i+1);
            //마지막 요소 제거 
            selected.remove(selected.size() -1);

        }

    }

    // 도시 치킨 거리 계산 
    private static int calculateCityDistance(List<int[]> selected){

        //각 집을 기준으로 구한 치킨 거리 합
        int cityDistance = 0;

        //집을 기준으로 거리가 가장 짧은 치킨 거리를 계산 
        for (int[] house: houses){
            int minDistance = Integer.MAX_VALUE;
            for(int[] chickenShop: selected){
                //거리 계산 
                int distance = Math.abs(house[0]-chickenShop[0]) + Math.abs(house[1]-chickenShop[1]);
                //최소값 업데이트 
                minDistance = Math.min(minDistance, distance);
            }
            cityDistance += minDistance;

        }
        return cityDistance;
    }
}