package 프머스.LV2;

class 멀리뛰기 {

    public long solution(int n) {
        long mod = 1234567l;
        // d[i] = i 칸에 도달하는 방법의 수
        // d[i] = d[i-1] + d[i-2];
        long[] d = new long[n+1];
        d[1] = 1L;
        if(n !=1) d[2] = 2L;

        for(int i = 3 ; i <= n ; i++){
            d[i] = (d[i-1] + d[i-2])%mod;
        }
        return d[n];
    }
}
