class Solution {
    /*
    * "t divides s" => s = t + ... + t

    if (x dievides str1, str2)
    str1 = x + ... + x
    str2 = x + ... + x

    gcd(ABABAB, ABAB) = AB
    ABABAB = AB + AB + AB
    ABAB = AB + AB

    gcd(6, 4) = 2
    6 = 2 + 2 + 2
    4 = 2 + 2
    */
    public String gcdOfStrings(String str1, String str2) {
        // str1, str2의 gcd가 없는 경우(즉 완전히 다른 문자)
        // if (x dievides str1, str2) => false
        if (!(str1 + str2).equals(str2 + str1)) return "";

        // if (x dievides str1, str2) => true
        int gcsRs = gcd(str1.length(), str2.length());
        return str1.substring(0, gcsRs);
    }
    
    // 유클리드 호제법을 이용한 gcd 계산
    //a % b 연산을 하여 b가 0이 될때까지, 반복문을 돌게 되고, b가 0인 순간의 a를 GCD로 판단
    private int gcd(int a, int b) {
        int tmp;

        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd2(b, a % b);
    }
}