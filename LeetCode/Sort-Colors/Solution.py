case red:
    swap(nums[l], nums[m]);
    l++, m++;
    break;
case white:
    m++;
    break;
case blue:
    swap(nums[m], nums[r]);
    r--;