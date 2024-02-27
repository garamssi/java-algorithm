package week8;

import java.util.Arrays;

/**
 * https://www.google.com/search?q=%EA%B5%AC%EA%B8%80%EB%B2%88%EC%97%AD&oq=%EA%B5%AC%EA%B8%80%EB%B2%88%EC%97%AD&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg70gEIMzgwMmowajGoAgCwAgA&sourceid=chrome&ie=UTF-8
 * 2300. Successful Pairs of Spells and Potions
 */
public class H_SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions = {8,5,2,1,6,7};  // 1,2,5,6,7,8

        long success = 16;

        int[] answer = successfulPairs(spells, potions, success);
        System.out.println(answer);
    }

    // 이중 Loop (Time Limit)
//    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
//        int length = spells.length;
//        int[] pair = new int[length];
//
//        for (int i = 0; i < spells.length; i++) {
//            int count = 0;
//            int spell = spells[i];
//
//            for(int potion : potions) {
//                if((long) potion * spell >= success) {
//                    count ++;
//                }
//            }
//
//            pair[i] = count;
//        }
//
//        return pair;
//    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int spellLength = spells.length;
        int[] pair = new int[spellLength];

        for(int i = 0; i < spellLength; i++) {
            int minRange = 0;
            int maxRange = potions.length - 1;

            while(minRange <= maxRange) {
                int mid = minRange + (maxRange - minRange) / 2;

                if((long) potions[mid] * spells[i] >= success) {
                    maxRange = mid - 1;
                }else {
                    minRange = mid + 1;
                }
            }

            pair[i] = potions.length - minRange;
        }

        return pair;
    }
}
