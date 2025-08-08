class Solution {
public:
    vector<pair<int,int>> pourings = {{100,0},{75,25},{50,50},{25,75}};

    vector<vector<double>> dp;

    double solve(int A, int B, vector<vector<double>>& dp){
        if(A<=0 && B<=0){
            return 0.5;
        }else if(A<=0){
            return 1;
        }else if(B<=0){
            return 0;
        }
        
        if(dp[A][B] != -1.0) return dp[A][B]; 
        double probability = 0;

        for(auto &it : pourings){
            int aTaken = it.first;
            int bTaken = it.second;

            probability += solve(A - aTaken, B - bTaken,dp);
        }

        return dp[A][B] = 0.25*probability;
    }

    double soupServings(int n) {
        if(n>=5000) return 1;
        dp.resize(n+1,vector<double>(n+1,-1.0));

        return solve(n,n,dp);
    }
};