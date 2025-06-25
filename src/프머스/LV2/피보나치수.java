package 프머스.LV2;

class 피보나치수 {
    static int[] d;
    static int mod = 1234567;
    public int solution(int n) {
        d = new int[n+1];
        d[0] = 0;
        d[1] = 1;
        // d[i] = i 번째 피보나치 수
        for(int i = 2 ; i <= n ; i++){
            d[i] = (d[i-2] + d[i-1]) % mod;
        }

        return d[n];
    }
}
