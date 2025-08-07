package 프머스.LV1;

class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {

        long total = 0;

        for(int i = 1 ; i <= count ; i++){
            total += (i * price);
        }

        return (total - money) >= 0 ? total - money : 0;
    }
}