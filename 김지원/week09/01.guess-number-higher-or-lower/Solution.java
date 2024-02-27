public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int first = 1;
        int last = n;

        while (first <= last) {
            // int mid = (int) ((((long) first + last) / 2)); // 형변환 O
            int mid = first + (last - first) / 2; // 형변환 X
            int rs = guess(mid);
            if (rs == -1) {
                last = mid - 1;
            } else if (rs == 1) {
                first = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}