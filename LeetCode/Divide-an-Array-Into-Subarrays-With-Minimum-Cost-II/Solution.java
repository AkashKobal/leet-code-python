void rebalance() {
    int need = min(K, windowSize());
    //if we have more elements in low set than needed,
    //we transfer the highest ones into the high set
    while((int)low.size() > need){
        auto it = prev(low.end());
        int x = *it;
        low.erase(it);
        sumLow -= x;
        high.insert(x);
    }
    //if we have less elements than needed in the low set,
    //we transfer the lowest ones from high set into the low set
    while((int)low.size() < need && !high.empty()){
        auto it = high.begin();
        int x = *it;
        high.erase(it);
        low.insert(x);
        sumLow += x;
    }
}