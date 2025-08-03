import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> firstBas = new HashMap<>();
        Map<Integer, Integer> secBas = new HashMap<>();
        Map<Integer, Integer> mixBasket = new HashMap<>();

        for (int it : basket1) {
            firstBas.put(it, firstBas.getOrDefault(it, 0) + 1);
            mixBasket.put(it, mixBasket.getOrDefault(it, 0) + 1);
        }

        for (int it : basket2) {
            secBas.put(it, secBas.getOrDefault(it, 0) + 1);
            mixBasket.put(it, mixBasket.getOrDefault(it, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mixBasket.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return -1;
            }
        }

        List<Integer> toSwap1 = new ArrayList<>();
        List<Integer> toSwap2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mixBasket.entrySet()) {
            int key = entry.getKey();
            int diff = Math.abs(firstBas.getOrDefault(key, 0) - secBas.getOrDefault(key, 0)) / 2;

            if (firstBas.getOrDefault(key, 0) > secBas.getOrDefault(key, 0)) {
                for (int i = 0; i < diff; i++) toSwap1.add(key);
            } else if (secBas.getOrDefault(key, 0) > firstBas.getOrDefault(key, 0)) {
                for (int i = 0; i < diff; i++) toSwap2.add(key);
            }
        }

        Collections.sort(toSwap1);
        toSwap2.sort(Collections.reverseOrder());

        int n = toSwap1.size();
        int globalMin = Integer.MAX_VALUE;

        for (int it : basket1) globalMin = Math.min(globalMin, it);
        for (int it : basket2) globalMin = Math.min(globalMin, it);

        long result = 0;

        for (int i = 0; i < n; i++) {
            result += Math.min(Math.min(toSwap1.get(i), toSwap2.get(i)), 2 * globalMin);
        }

        return result;
    }
}
