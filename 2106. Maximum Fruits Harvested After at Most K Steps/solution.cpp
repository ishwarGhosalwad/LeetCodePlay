class Solution {
public:
    bool isReachable(int left,int right, int startPos,int k){
        int leftFirst = abs(startPos - left) + (right - left);
        int rightFirst = abs(startPos - right) + (right - left);

        return min(leftFirst,rightFirst) <= k;
    }
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        int n =fruits.size();
        int sum = 0;
        int left = 0;
        int maxFruits = 0;

        for(int right =0;right<n;right++){
            sum += fruits[right][1];

            while(left<= right && !isReachable(fruits[left][0],fruits[right][0],startPos,k)){
                sum -= fruits[left][1];
                left++;
            }

            maxFruits = max(maxFruits, sum);        
        }

        return maxFruits;
        
    }
};