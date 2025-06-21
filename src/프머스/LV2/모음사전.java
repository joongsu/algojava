package 프머스.LV2;

class 모음사전 {
    static int cnt,answer;
    static String[] base = new String[]{"A","E","I","O","U"};
    static String target;

    public int solution(String word) {
        // A E I O U

        target = word;
        dfs(new StringBuilder());

        return answer;
    }

    public static void dfs(StringBuilder sb){
        if(answer != 0) return;
        if(sb.toString().equals(target)) {
            answer = cnt;
            return;
        }
        if(sb.length() == 5) return;


        for(int i = 0 ; i < 5 ; i++){
            sb.append(base[i]);
            cnt++;
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
