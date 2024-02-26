package week8;

import java.util.Arrays;

/**
 * https://www.google.com/search?q=%EA%B5%AC%EA%B8%80%EB%B2%88%EC%97%AD&oq=%EA%B5%AC%EA%B8%80%EB%B2%88%EC%97%AD&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg70gEIMzgwMmowajGoAgCwAgA&sourceid=chrome&ie=UTF-8
 * 2300. Successful Pairs of Spells and Potions
 */
public class E_SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
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
        Arrays.sort(spells);

        int length = spells.length;
        int[] pair = new int[length];

        for(int i = 0; i < length; i++) {
            pair[i] = binarySearch(potions, spells[i], success);
        }

        return pair;
    }

    public static int binarySearch(int[] potions, int spell, long success) {
        int minRange = 0;
        int maxRange = potions.length;

        while(minRange <= maxRange) {
            
        }

    }


}
