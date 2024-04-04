import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// countList : 숫자 N을 index 번 연산하여 만들 수 있는 수들의 집합
// i번 연산하여 만들 수 있는 수 => j 가 1 <= i 일때 j 집합의 수와 i-j 집합의 수들을 연산하여 구할 수 있다.

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        }
        countList.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> pre = countList.get(j);
                Set<Integer> post = countList.get(i - j);

                for (Integer preNum : pre) {
                    for (Integer postNum : post) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);
                        if (postNum != 0) {
                            countSet.add(preNum / postNum);
                        }
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> countSet : countList) {
            if (countSet.contains(number)) {
                return countList.indexOf(countSet);
            }
        }
        return -1;
    }
}