package garam.week5.thursday.문제3_DecodeString;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decodeString("3[a2[c]]")); // "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef"

    }

    public static String decodeString(String s) {

        Deque<Integer>numStack=new ArrayDeque<>();
        Deque<StringBuilder>strBuild=new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        int num=0;
        for(char c:s.toCharArray()){
            if(c>='0' && c<='9'){
                num=num*10 +c -'0';
            }
            else if(c=='['){
                strBuild.push(str);
                str=new StringBuilder();
                numStack.push(num);
                num=0;
            }else if(c==']'){
                StringBuilder temp=str;
                str=strBuild.pop();
                int count=numStack.pop();
                while(count-->0){
                    str.append(temp);
                }
            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}
