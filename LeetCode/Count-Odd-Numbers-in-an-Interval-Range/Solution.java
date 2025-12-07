# Native : python (NOT OPTIMAL)
if high == 0:
   return 0

counter = 0
for i in range(low, high):
   if i % 2 != 0:
      counter += 1
return counter