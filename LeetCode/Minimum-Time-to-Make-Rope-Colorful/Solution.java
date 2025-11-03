if (prev == color)
    f(i, prev) = neededTime[i] + f(i + 1, prev)
else
    f(i, prev) = min(neededTime[i] + f(i + 1, prev), f(i + 1, curr))