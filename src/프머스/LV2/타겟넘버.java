package 프머스.LV2;

class 타겟넘버 {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,target,0);
        return answer;
    }

    public static void dfs(int[] numbers , int depth,int target,int sum){

        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }


        dfs(numbers,depth+1,target,sum + numbers[depth]);
        dfs(numbers,depth+1,target,sum - numbers[depth]);

    }
}
