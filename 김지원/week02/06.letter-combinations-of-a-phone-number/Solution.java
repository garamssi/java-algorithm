class Solution {

    private List<String> result;
    private Map<Integer, List<String>> keypad;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        keypad = new HashMap<>();
        keypad.put(0, new ArrayList<>());
        keypad.put(1, new ArrayList<>());
        keypad.put(2, List.of("a", "b", "c"));
        keypad.put(3, List.of("d", "e", "f"));
        keypad.put(4, List.of("g", "h", "i"));
        keypad.put(5, List.of("j", "k", "l"));
        keypad.put(6, List.of("m", "n", "o"));
        keypad.put(7, List.of("p", "q", "r", "s"));
        keypad.put(8, List.of("t", "u", "v"));
        keypad.put(9, List.of("w", "x", "y", "z"));

        int digitsLength = digits.length();
        dfs(0, "", digits, digitsLength);

        return result;
    }

    public void dfs(int index, String temp, String digits, int digitsLength) {
        if (index == digitsLength && !temp.isEmpty()) {
            result.add(temp);
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (String alpha : keypad.get(digit)) {
            dfs(index + 1, temp + alpha, digits, digitsLength);
        }
    }
}