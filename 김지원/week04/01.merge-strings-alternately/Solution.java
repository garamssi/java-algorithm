class Solution {
    
    public String mergeAlternately(String word1, String word2) {
        String result = "";

        int size = Math.min(word1.length(), word2.length());

        for (int i = 0; i < size; i++) {
            result += word1.charAt(i);
            result += word2.charAt(i);
        }

        if (word1.length() > size) {
            result += word1.substring(size);
        }

        if (word2.length() > size) {
            result += word2.substring(size);
        }

        return result;
    }
}