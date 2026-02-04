vector<pair<int,int>> decompose(vector<int>& nums){
    int n = (int)nums.size();
    vector<pair<int,int>> subarrays;

    int l = 0;
    for(int i = 1; i < n; i ++){
        // If we fail strict decreasing at boundary i-1 -> i, end the current subarray.
        if(nums[i - 1] <= nums[i]){
            subarrays.push_back({l, i - 1});
            l = i;
        }
    }
    //last subarray
    subarrays.push_back({l, n - 1});
    return subarrays;
}