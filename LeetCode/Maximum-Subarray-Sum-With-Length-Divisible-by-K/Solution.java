for(int i=0; i<n; i++){
    prefix+=nums[i];// add nums[i] to prefix
    ll& ksum=minS[i%k]; // pass by reference
    ans=max(ans, prefix-ksum); // subarray of length k-multiple
    //take minS[i%k] as the min among prefix sum up to index r=i%k
    ksum=min(prefix, ksum); 
}