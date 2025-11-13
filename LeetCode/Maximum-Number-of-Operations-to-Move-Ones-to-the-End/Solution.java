for(int i=1; i<n; i++){
    if (s[i]=='1') cnt1++;
    else if (s[i-1]=='1') cnt+=cnt1;
}