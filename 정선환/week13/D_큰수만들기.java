package week13;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * 큰 수 만들기
 */
public class D_큰수만들기 {
    public static void main(String[] args) {
//        System.out.println(solution("1924", 2)); // "94"

        System.out.println(solution("1231234", 10)); // "3234"

//        System.out.println(solution("4177252841", 4)); // "775841"

        // 4177252841   0
        // 477252841    1
        // 77252841    1
        // 7752841     2
        // 775841

    }

    public static String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        while (k-- > 0) {
            stack.pop();
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

//    public static String solution(String number, int k) {
//        char[] charArray = number.toCharArray();
//        boolean[] booleanArray = new boolean[charArray.length];
//        Arrays.fill(booleanArray, true);
//
//        int removeCount = 0;
//        for (int i = 0; i < charArray.length; i++) {
//            if (removeCount == k) {
//                break;
//            }
//
//            char center = charArray[i];
//
//            if (i == 0) {
//                char right = charArray[i + 1];
//
//                if (center > right) {
//                    booleanArray[i + 1] = false;
//                    removeCount++;
//                }
//            } else if (i == charArray.length - 1) {
//                char left = charArray[i - 1];
//                if (center > left) {
//                    booleanArray[i - 1] = false;
//                    removeCount++;
//                }
//
//            } else {
//                char left = charArray[i - 1];
//                if (center > left) {
//                    booleanArray[i - 1] = false;
//                    removeCount++;
//                }
//
//                char right = charArray[i + 1];
//                if (center > right) {
//                    booleanArray[i + 1] = false;
//                    removeCount++;
//                }
//            }
//        }
//
//        String answer = "";
//        for (int i = 0; i < booleanArray.length; i++) {
//            if(booleanArray[i]) {
//                answer += charArray[i];
//            }
//        }
//
//        return answer;
//    }


//    public static String solution(String number, int k) {
//        List<Character> charList = new ArrayList<>();
//        for (char c : number.toCharArray()) {
//            charList.add(c);
//        }
//
//        int removeCount = 0;
//        int i = 0;
//        while(removeCount < k) {
//            char center = charList.get(i);
//
//            if(i == 0) {
//                char right = charList.get(i + 1);
//                if(center > right) {
//                    charList.remove(i + 1);
//                    removeCount++;
//                    i++;
//                }
//
//            }else if(i == charList.size() - 1) {
//                char left = charList.get(i - 1);
//                if(center > left) {
//                    charList.remove(i - 1);
//                    removeCount++;
//                }
//
//            }else {
//                char left = charList.get(i - 1);
//                if(center > left) {
//                    charList.remove(i - 1);
//                    removeCount++;
//                }
//
//                char right = charList.get(i + 1);
//                if(center > right) {
//                    charList.remove(i + 1);
//                    removeCount++;
//                    i++;
//                }
//            }
//        }
//
//        return charList.stream().map(String::valueOf).collect(Collectors.joining());
//
//    }


//    public static String solution(String number, int k) {
//        List<Character> charList = new ArrayList<>();
//        for (char c : number.toCharArray()) {
//            charList.add(c);
//        }
//
//        int removeCount = 0;
//        while(removeCount < k) {
//            for (int i = 0; i < charList.size(); i++) {
//                char front = charList.get(i);
//                char back = charList.get(i + 1);
//
//                if (front == back) {
//                    i++;
//                    continue;
//                }
//
//                if(front < back) {
//                    charList.remove(i);
//                    removeCount++;
//                    break;
//                }
//
//                if(front > back) {
//                    charList.remove(i + 1);
//                    removeCount++;
//                    break;
//                }
//            }
//        }
//
//        return charList.stream().map(String::valueOf).collect(Collectors.joining());
//    }
}
