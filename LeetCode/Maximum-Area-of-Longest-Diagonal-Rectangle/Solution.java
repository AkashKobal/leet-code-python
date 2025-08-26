    int maxArea=0;
    double maxD = 0;
    int n = dimensions.size();
    int l,b;
    double d;
    
    for(int i=0;i<n;i++) {
        
         l = dimensions[i][0];
         b = dimensions[i][1];
         d = sqrt(l*l + b*b);
        // cout<<d<<",";
        if(d>=maxD) {
            maxArea = l*b;
            maxD=d;
        } 
    }
    
    return maxArea;
    
}