public class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        int i = 0, n = fruits.length, maxFruits = 0;

        for(int j=0;j<n;j++){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0) + 1);

            while(mp.size() > 2){
                mp.put(fruits[i],mp.get(fruits[i]) - 1);
                if(mp.get(fruits[i]) == 0){
                    mp.remove(fruits[i]);
                }
                i++;
            }

            maxFruits = Math.max(maxFruits,j-i+1);
        }

        return maxFruits;
    }
}