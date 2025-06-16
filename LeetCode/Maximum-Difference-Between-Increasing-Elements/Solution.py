int x=nums[i];
if (x<=xMin)
    xMin=x;// update the new xMin
else // x>xMin
    maxD=max(maxD, x-xMin); //update maxD