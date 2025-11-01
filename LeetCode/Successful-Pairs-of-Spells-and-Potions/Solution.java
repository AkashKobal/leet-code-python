def binarySearchForMinVal()
    l, r = lower_bound, upper_bound
    while l < r:
        mid = (l + r)//2 #round down
        if feasible(mid):
            r = mid #check for possible smaller values that work
        else:
            l = mid + 1 #values smaller than or equal to mid do not work. Reduce search space to values greater than mid.
    return l