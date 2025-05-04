class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int freq[100]={0},xmin=100, xmax=0;
        for(auto& d: dominoes){
            int d0=d[0], d1=d[1], x=(d0<d1)?10*d0+d1:10*d1+d0;
            freq[x]++;
            xmin=min(x, xmin);
            xmax=max(x, xmax);
        }
        int cnt=0;
        for(int x=xmin; x<=xmax; x++){
            const int f=freq[x];
            if (f<=1) continue;
            cnt+=f*(f-1)/2;
        }
        return cnt;
    }
};