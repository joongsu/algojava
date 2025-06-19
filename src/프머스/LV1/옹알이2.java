package 프머스.LV1;


class 옹알이2 {
    public int solution(String[] babbling) {
        // aya , ye , woo , ma
        int answer = 0;
        String[] filter = {"aya","ye","woo","ma"};

        for(int i = 0 ; i<babbling.length; i++){
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye")||babbling[i].contains("woowoo")||babbling[i].contains("mama")) continue;

            for(int j = 0 ; j< filter.length ; j++){
                babbling[i] = babbling[i].replace(filter[j], " ");
            }
            babbling[i] = babbling[i].replace(" ","");

            if(babbling[i].length() == 0) answer++;

        }
        return answer;
    }
}
