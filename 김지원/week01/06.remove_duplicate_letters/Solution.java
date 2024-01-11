class Solution {

    public String removeDuplicateLetters(String s) {
        for (char c : toSortedSet(s)) {
            String suffix = s.subString(s.index.of(s));

            if (toSortSet(s).equals(toSortSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""))
            }
        }
    }

    private Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < s.length; i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public String removeDuplicateLetters(String s) {
        // 문자의 개수를 계산해서 담아둘 변수 선언
        Map<Character, Integer> counter = new HashMap<>();
        // 이미 처리한 문자 여부를 확인하기 위한 변수 선언
        Map<Character, Boolean> seen = new HashMap<>();
        // 스택 선언
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);

            if (seen.getOrDefault(c, false)) {
                continue;
            }

            // 스택에 있는 값이 c 보다 순서가 뒤쪽이고, s 문자열에서 c 뒤에 처리 할 수있는 스택 값이 있다면..
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }

            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}