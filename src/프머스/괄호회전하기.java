package 프머스;

import java.util.*;
class 괄호회전하기 {
    public int solution(String s) {

        int answer = 0;

        for(int i = 0 ; i< s.length(); i++){
            Stack<Character> stack = new Stack<>();

            String rotate = s.substring(i);
            if(i != 0){
                rotate += (s.substring(0,i));//rotate
            }

            for(int j = 0 ; j<s.length();j++){
                char c = rotate.charAt(j);

                if(!stack.isEmpty() && (c == ')' || c == '}' || c == ']')){
                    if(stack.peek() == '(' && c == ')'){
                        stack.pop();
                    }else if(stack.peek() == '{' && c == '}'){
                        stack.pop();
                    }else if(stack.peek() == '[' && c == ']'){
                        stack.pop();
                    }

                }else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }

        }


        return answer;
    }
}
