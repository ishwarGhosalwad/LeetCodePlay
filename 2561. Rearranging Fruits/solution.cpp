class Solution {
public:
    long long minCost(vector<int>& basket1, vector<int>& basket2) {
        unordered_map<int,int> firstBas;
        unordered_map<int,int> secBas;
        unordered_map<int,int> mixBasket;

        for(int &it : basket1){
            firstBas[it]++;
            mixBasket[it]++;
        }

        for(int &it : basket2){
            secBas[it]++;
            mixBasket[it]++;
        }

        for(auto &[key,value] : mixBasket){
            if(value % 2 != 0){
                return -1;
            }
        }

        vector<int> toSwap1;
        vector<int> toSwap2;


        for(auto &[key,value] : mixBasket){
            int diff = abs(firstBas[key] - secBas[key]) / 2;

            if (firstBas[key] > secBas[key]) {
                while (diff--) toSwap1.push_back(key);
            } else if (secBas[key] > firstBas[key]) {
                while (diff--) toSwap2.push_back(key);
            }
        }

        sort(toSwap1.begin(),toSwap1.end());
        sort(toSwap2.rbegin(), toSwap2.rend());

        int n = toSwap1.size();
        int globalMin = INT_MAX;
        for(int &it : basket1) globalMin = min(globalMin,it);
        for(int &it : basket2) globalMin = min(globalMin,it);

        long long result = 0;

        for(int i=0;i<n;i++){
            result += min(min(toSwap1[i],toSwap2[i]),2*globalMin);
        }

        return result;

    }
};