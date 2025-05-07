auto [t, i, j] = pq.top();
pq.pop();

// reach the destination
if (i == n - 1 && j == m - 1)
    return t;

// Traverse all four directions
for (int a = 0; a < 4; a++) {
    int r = i + d[a], s = j + d[a + 1];
    if (isOutside(r, s, n, m)) continue;

    // minimum time to reach (r, s)
    int nextTime = max(t, moveTime[r][s]) + 1; // Wait if necessary

    // update if this path having quicker time
    if (nextTime < time[r][s]) {
        time[r][s] = nextTime;
        pq.emplace(nextTime, r, s);
    }
}