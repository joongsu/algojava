package 프머스.LV2;
import java.util.*;

class 호텔대실 {
    public int solution(String[][] book_time) {

        Arrays.sort(book_time ,(a,b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for(int i = 0 ; i < book_time.length ; i++){
            int s = parseTime(book_time[i][0]);
            int e = parseTime(book_time[i][1]) + 10;

            while(!pq.isEmpty() && pq.peek() <= s){
                pq.poll();
            }
            pq.add(e);

            ans = Math.max(ans, pq.size());

        }

        return ans;
    }
    public int parseTime(String s){
        String[] time = s.split(":");

        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
