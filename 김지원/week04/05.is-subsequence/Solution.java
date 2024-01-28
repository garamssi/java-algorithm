class Solution {
    
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;

        for (int i = 0; i < t.length(); i++) {
            if (sIndex == s.length()) {
                return true;
            }

            if (s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}