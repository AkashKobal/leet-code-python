class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        # Solution 2: Eliminates bisect 
        n = len(s)
        vals = [ord(c) - 48 for c in s]
        INF = 10**9
        res = -INF
        for a in range(5):
            for b in range(5):
                if a == b: continue
                d = [0] * (n + 1)
                pa = [0] * (n + 1)
                cb = [0] * (n + 1)
                for i, v in enumerate(vals, 1):
                    da = v == a
                    db = v == b
                    d[i] = d[i-1] + da - db
                    pa[i] = pa[i-1] ^ da
                    cb[i] = cb[i-1] + db
                cb_list = [[] for _ in range(4)]
                dm = [[] for _ in range(4)]
                ptr = [0, 0, 0, 0]
                for j in range(k, n+1):
                    i = j - k
                    idx = (pa[i] << 1) | (cb[i] & 1)
                    di = d[i]
                    lst_dm = dm[idx]
                    lst_dm.append(di if not lst_dm or di < lst_dm[-1] else lst_dm[-1])
                    cb_list[idx].append(cb[i])
                    tidx = ((pa[j] ^ 1) << 1) | (cb[j] & 1)
                    T = cb[j] - 2
                    lst_cb = cb_list[tidx]
                    p = ptr[tidx]
                    L = len(lst_cb)
                    while p < L and lst_cb[p] <= T:
                        p += 1
                    ptr[tidx] = p
                    if p:
                        diff = d[j] - dm[tidx][p-1]
                        if diff > res:
                            res = diff
        return res

        # Solution 1: First Approach
        n, res = len(s), -10**9
        for a in '01234':
            for b in '01234':
                if a == b: continue
                d = [0]*(n+1)
                pa = [0]*(n+1)
                cb = [0]*(n+1)
                for i, c in enumerate(s, 1):
                    d[i] = d[i-1] + (c == a) - (c == b)
                    pa[i] = pa[i-1] ^ (c == a)
                    cb[i] = cb[i-1] + (c == b)
                lst = [[[] for _ in range(2)] for _ in range(2)]
                pm  = [[[] for _ in range(2)] for _ in range(2)]
                for j in range(k, n+1):
                    i = j - k
                    ai, bi = pa[i], cb[i] & 1
                    if lst[ai][bi]:
                        pm[ai][bi].append(min(pm[ai][bi][-1], d[i]))
                    else:
                        pm[ai][bi].append(d[i])
                    lst[ai][bi].append(cb[i])
                    aj, bj = pa[j], cb[j] & 1
                    na, nb = 1 - aj, bj
                    arr = lst[na][nb]
                    if arr:
                        T = cb[j] - 2
                        h = bisect_right(arr, T) - 1
                        if h >= 0:
                            res = max(res, d[j] - pm[na][nb][h])
        return res