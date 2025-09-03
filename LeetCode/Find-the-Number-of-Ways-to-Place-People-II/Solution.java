for(int i=0; i<n-1; i++){
    int y=INT_MAX,  yi=P[i][1];
    // Search the valid pairs (P[j], P[i])
    for(int j = i+1; j<n; j++){
        const int yj=P[j][1];// y-coordinate for P[j]
        // yj has y-coordinate in [yi, y)
        // when yj in this region, P[j] cannot in between other pairs
        // (P[j], P[i]) is a valid pair
        if (yj>=yi && y>yj){
            ans++;
            y=yj;// lower the upper bound y
            if (yi==yj) break;//this early stop to make code faster
        }
    }
}