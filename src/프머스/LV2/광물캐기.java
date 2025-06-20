package 프머스.LV2;

import java.util.*;
class 광물캐기 {
    static int answer;
    public int solution(int[] picks, String[] minerals) {
        //곡괭이는 5번 사용 가능 , 한 번 택하면 끝까지 사용해야 함
        //광물 5개당 피로도 합 구한뒤 최소 선택

        int totalPick = picks[0] + picks[1] + picks[2];
        int n = minerals.length;
        int[][] mineralGroup = new int[totalPick][6];

        for(int i = 0 ; i < Math.min(totalPick * 5 , n) ; i += 5){
            int sum = 0;
            int v = 0;
            for(int j = i ; j < Math.min(i + 5, n); j++){

                switch(minerals[j]){
                    case "diamond" :
                        v = 25;
                        break;
                    case "iron" :
                        v = 5;
                        break;
                    case "stone" :
                        v = 1;
                        break;
                }
                sum += v;
                mineralGroup[i / 5][j % 5 + 1] = v;
            }
            mineralGroup[i/5][0] = sum;
        }

        Arrays.sort(mineralGroup, (a,b) -> b[0] - a[0]);

        // 0행 0 열에는 가장 피로도 큰 값이 있음
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        for(int i = 0 ; i < totalPick ; i++){
            int[] temp = mineralGroup[i];
            String pick = "";
            if(dia > 0){
                dia--;
                pick = "diamond";
            }else if(iron > 0){
                iron--;
                pick = "iron";
            }else if(stone > 0){
                stone--;
                pick = "stone";
            }

            for(int j = 1; j < 6 ; j++){
                switch(pick){
                    case "diamond" :
                        answer += (int) Math.ceil(temp[j] / 25.0);
                        break;
                    case "iron":
                        answer += (int)Math.ceil(temp[j] / 5.0);
                        break;
                    case "stone":
                        answer += temp[j];
                        break;
                }
            }
        }
        return answer;
    }
}
