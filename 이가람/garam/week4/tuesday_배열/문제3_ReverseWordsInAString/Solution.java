package garam.week4.tuesday_배열.문제3_ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s){
//        String[] list = s.split(" ");
//        list = Arrays.stream(list).filter(str -> !str.isEmpty()).toArray(String[]::new);

        // 공백이 하나이든 여러개이든 공백 무조건 제거
        String[] list = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // 마지막 문자 추가
        result.append(list[list.length-1]);

        // 마지막에서 2번째 값부터 시작해서 첫 번째 값까지 추가.
        for(int i=list.length-2; i>=0; i--) {
            result.append(" "+list[i]);
        }

        return result.toString();

    }


}
