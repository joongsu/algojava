package 프머스.알고리즘고득점kit.완전탐색;

import java.util.*;
class 모의고사 {
    static class Student{
        int num;
        int cnt;

        Student(int n, int c){
            this.num = n;
            this.cnt = c;
        }
    }
    public int[] solution(int[] answers) {
        int[][] v = {{1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        Student[] s = new Student[3];
        for(int i = 1 ; i<= 3 ; i++){
            s[i-1] = new Student(i,0);
        }


        for(int i = 0  ; i< answers.length ; i++){
            if(answers[i] == v[0][i%5]){ // 1번
                s[0].cnt += 1;
            }
            if(answers[i] == v[1][i%8]){
                s[1].cnt += 1;
            }
            if(answers[i] == v[2][i%10]){
                s[2].cnt += 1;
            }
        }
        Arrays.sort(s, (a,b) -> {
            return b.cnt - a.cnt;
        });

        int k = s[0].cnt;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++){
            if(k == s[i].cnt){
                list.add(s[i].num);
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}
