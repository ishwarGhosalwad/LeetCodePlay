
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += fruits[right][1];

            // Try shrinking the window from the left if the total cost exceeds k
            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                sum -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, sum);
        }

        return maxFruits;
    }

    // Check if you can reach all fruits from posL to posR within k steps
    private boolean isReachable(int posL, int posR, int start, int k) {
        int leftFirst = Math.abs(start - posL) + Math.abs(posR - posL); // go left first
        int rightFirst = Math.abs(start - posR) + Math.abs(posR - posL); // go right first
        return Math.min(leftFirst, rightFirst) <= k;
    }
}
