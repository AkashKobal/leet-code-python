bool isSorted(vector<int> v){
    for(int i = 0; i < (int)v.size() - 1; i ++){
        if(v[i] > v[i + 1]){
            return false;
        }
    }
    return true;
}