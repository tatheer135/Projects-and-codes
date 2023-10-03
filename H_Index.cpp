// to find the H - Index of the array of citations and returns researcher's h-index
class Solution {
public:
    int HIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end(),greater<int>());
        int ans=0;
        for(int i=0;i<citations.size();i++){
            if(citations[i]>=i+1)ans++;
            else break;
        }
        return ans;
    }
};
