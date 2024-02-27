class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] rs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int cnt = succesCnt(spells[i], potions, success);
            rs[i] = cnt;
        }

        return rs;
    }

    private int succesCnt(int spell, int[] potions, long success) {
        int first = 0;
        int last = potions.length - 1;

        int minIdx = -1;
        while (first <= last) {
            int mid = (first + last) / 2;
            long product = (long) spell * potions[mid];
            if (product < success) {
                first = mid + 1;
            } else if (product >= success) {
                minIdx = mid;
                last = mid - 1;
            }
        }

        if (minIdx == -1) {
            return 0;
        } else {
            return potions.length - minIdx;
        }
        // return potions.length - first;
    }
}