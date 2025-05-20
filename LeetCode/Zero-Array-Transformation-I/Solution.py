int op=0;
for(int i=0; i<n; i++) {    
    op+=freq[i];
    if (nums[i]>op) return 0;
}
return 1;
