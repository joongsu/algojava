package 프머스.LV1;

class 콜라문제 {
    public int solution(int a, int b, int n) {

        // a 개당 b 개의 병을 준다. , 갖고 있는 병 갯수 n개
        int answer = 0;

        while(n >= a){

            int m = n / a * b; // 받는 병 갯수 1 4
            int k = n % a; // 남은 병
            answer += m;
            n = m + k;
        }


        return answer;
    }
}
