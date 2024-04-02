
class Solution {
    public int solution(String name) {
        int answer = 0;
        int nameLength = name.length();
        int moveCount = nameLength - 1;
            
        for (int i = 0; i < nameLength; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // A가 끝나는 위치까지 탐색한다.
            int cursorIndex = i + 1;

            while (cursorIndex < nameLength && name.charAt(cursorIndex) == 'A') {
                cursorIndex++;
            }
            // BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
            moveCount = Math.min(moveCount, i * 2 + nameLength - cursorIndex);
            // CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
            moveCount = Math.min(moveCount, (nameLength - cursorIndex) * 2 + i);
        }

        return answer + moveCount;
    }
}