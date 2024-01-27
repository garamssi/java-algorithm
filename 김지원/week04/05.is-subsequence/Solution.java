class Solution {
    
    public boolean isSubsequence(String s, String t) {
        int si = 0;

        for (int i = 0; i < t.length(); i++) {
            if (si >= s.length()) {
                return true;
            }

            if (s.charAt(si) == t.charAt(i)) {
                si++;
            }
        }

        return si == s.length();
    }
}