class Solution {

    public static long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> pql = new PriorityQueue<>(), pqr = new PriorityQueue<>();
        int p = 0, q = costs.length - 1;
        for (int i = 0; i < candidates && p <= q; i++) { // p > q: costs가 후보자 수보다 적은 경우.
            pql.add(costs[p]);
            p++;
        }

        for (int i = 0; i < candidates && p <= q; i++) {
            pqr.add(costs[q]);
            q--;
        }

        long total = 0;
        while (k > 0) {
            // (!prl.isEmpty() && !pqr.isEmpty()), pql.peek() <= pqr.peek() => pql.peek()
            // (!prl.isEmpty() && !pqr.isEmpty()), pql.peek() > pqr.peek() => pqr.peek()
            // prl.isEmpty() => pqr.peek()
            // pqr.isEmpty() => pql.peek()
            if (pqr.isEmpty() || (!pql.isEmpty() && pql.peek() <= pqr.peek())) {
                total += pql.poll();
                if (p <= q) { // p > q: costs가 후보자 수보다 적은 경우.
                    pql.add(costs[p]);
                    p++;
                }
            } else { // pqr이 비어있는 경우, pql.peek() > pqr.peek() 경우
                total += pqr.poll();
                if (p <= q) {
                    pqr.add(costs[q]);
                    q--;
                }
            }
            k--;
        }
        return total;
    }
}