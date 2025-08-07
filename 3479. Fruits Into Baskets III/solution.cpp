class Solution {
public:
    void buildSegmentTree(int i,int l,int r,vector<int>& baskets,vector<int>& segmentTree){
        if (l == r) {
            segmentTree[i] = baskets[l];
            return; // ✅ Fix 1
        }
        int mid = l + (r - l)/2;
        buildSegmentTree(2*i+1,l,mid,baskets,segmentTree);
        buildSegmentTree(2*i+2,mid+1,r,baskets,segmentTree);

        segmentTree[i] = max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
    }

    bool querySegmentTree(int i,int l,int r,int fruit,vector<int>& segmentTree){
        if(segmentTree[i] < fruit) return  false;


        if( l == r) {
            segmentTree[i] = -1;
            return true; 
        }

        int mid = l + (r-l)/2;
        bool placed = false;
        placed = querySegmentTree(2*i+1, l, mid, fruit, segmentTree);
        if(!placed){
            placed = querySegmentTree(2*i+2, mid+1, r, fruit, segmentTree);
        }

        segmentTree[i] = max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);

        return placed;
    }

    int numOfUnplacedFruits(vector<int>& fruits, vector<int>& baskets) {
        int n = baskets.size();

        vector<int> segmentTree(4*n,-1);

        buildSegmentTree(0,0,n-1,baskets,segmentTree);

        int count = 0;

        for(int num : fruits){
            if(querySegmentTree(0,0,n-1,num,segmentTree)){
                count++;
            }
        }

        return n - count;

    }
};
