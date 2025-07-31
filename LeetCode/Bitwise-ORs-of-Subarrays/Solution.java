you must have figured out by now that if we store values at i-1, I can use to for i.
Isnt this O(n2)?
Well it isnt.
Why?
1. Once a bit appers at a position, it cant dissappear (since we are doing OR operation).
2. So at max we will have no of bits values at prev instance.
Ex: 1011, it can never be 0011
Only possibility is 1111.