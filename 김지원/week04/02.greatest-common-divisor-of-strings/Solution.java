class Solution {

    public String gcdOfStrings(String str1, String str2) {
        // str1, str2의 gcd가 없는 경우(즉 완전히 다른 문자)
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcsRs = gcd(str1.length(), str2.length());
        return str1.substring(0, gcsRs);
    }

    private int gcd(int a, int b) {
        int tmp, n;

        //a에 큰 값을 위치시키기 위한 조건이다.
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }

        //b가 0이 될때까지(a%b), 반복문을 돌게 되고, b가 0인 순간의 a를 GCD로 판단하고 리턴한다
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
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