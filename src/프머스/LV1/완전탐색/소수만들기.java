package 프머스.LV1.완전탐색;

class 소수만들기 {

    static int[] arr;
    static int ans;
    public int solution(int[] nums) {

        arr = nums;

        dfs(0,0,0);


        return ans;
    }

    static void dfs(int k , int sum, int cnt){

        if(cnt == 3){
            System.out.println(sum);
            if(isPrime(sum)){
                ans++;
            }
            return;
        }

        for(int i = k ; i < arr.length ; i++){
            int v = sum + arr[i];
            dfs(i+1, v, cnt +1);
        }
    }

    static boolean isPrime(int k){

        for(int i = 2 ; i <= Math.sqrt(k) ; i++){
            if(k % i == 0){
                return false;
            }
        }
        return true;

    }
}
