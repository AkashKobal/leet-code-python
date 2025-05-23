# Let x=nums[i], consider not taking x^k , taking x^k
f(i, c)= max(x+f(i+1, c),(x^k)+f(i+1,1-c)) 