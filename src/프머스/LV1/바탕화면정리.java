package 프머스.LV1;


class 바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        // . 빈칸 , # 파일 , S -> E (S에서 E로 드래그한다)
        int[] start = {50,50};
        int[] end = {0,0};

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        for(int i = 0 ; i < row ; i++){
            for(int j= 0 ; j < col ; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    start[0] = Math.min(start[0],i);
                    start[1] = Math.min(start[1],j);
                    end[0] = Math.max(end[0],i);
                    end[1] = Math.max(end[1],j);
                }
            }
        }


        return new int[]{start[0],start[1],end[0]+1,end[1]+1};
    }
}
