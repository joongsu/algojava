package 프머스.LV2;

class 네트워크 {
    static int[] visited;
    static int[][] copyComputers;
    static int answer, d;

    public int solution(int n, int[][] computers) {

        copyComputers = new int[n][n];
        for(int i = 0 ; i< n ; i++){
            copyComputers[i] = computers[i].clone();
        }
        visited = new int[n];
        d = n;
        for(int i= 0  ; i< d ; i++){
            if(visited[i] != 1){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
    public static void dfs(int node){
        visited[node] = 1;
        for(int i = 0 ; i< d ; i++){
            if(copyComputers[node][i] == 1 && visited[i] != 1){
                dfs(i);
            }
        }
    }
}
