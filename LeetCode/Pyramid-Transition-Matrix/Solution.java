class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    private boolean backtrack(int i, StringBuilder current,StringBuilder base, int n,Set<String> allowed) {
        if (n == 0) return true;
        if (i == 0) {
            String key = base.toString();
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
        }
        if (i == n) {
            boolean res = backtrack(0, new StringBuilder(), current, n-1, allowed);
            memo.put(base.toString(), res);
            return res;
        }
        for (char ch = 'A'; ch <= 'F'; ++ch) {
            current.append(ch);
            StringBuilder block = new StringBuilder(base.substring(i, i + 2));
            block.append(ch);
            if (allowed.contains(block.toString()))
                if (backtrack(i + 1, current, base, n, allowed))
                    return true;
            current.deleteCharAt(current.length() - 1);
        }
        memo.put(base.toString(), false);
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<String> hset = new HashSet<>(allowed);
        return backtrack(0, new StringBuilder(),new StringBuilder(bottom),bottom.length() - 1,hset);
    }
}
