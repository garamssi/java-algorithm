class Solution {
    public int[] solution(int brown, int yellow) {
        int len = (brown + 4) / 2; // 가로 + 세로 

        for (int width = len - 3; width >= 3; width--) {
            int height = len - width;
            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }
        return new int[0];
    }
}