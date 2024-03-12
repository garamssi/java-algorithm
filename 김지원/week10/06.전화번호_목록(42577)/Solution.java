import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet();

        for (String phone : phone_book) {
            phoneSet.add(phone);
        }

        for (String phone : phoneSet) {
            for (int i = 0; i < phone.length(); i++) {
                if (phoneSet.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}