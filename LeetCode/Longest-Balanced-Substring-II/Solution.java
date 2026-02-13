class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        char[] arr = s.toCharArray();
        int ans = 0;

        // 1 character case
        ans = Math.max(ans, countOne(arr));

        // 2 character cases (all pairs)
        ans = Math.max(ans, countTwo('a', 'b', arr));
        ans = Math.max(ans, countTwo('b', 'c', arr));
        ans = Math.max(ans, countTwo('c', 'a', arr));

        // 3 character case
        ans = Math.max(ans, countThree(arr));

        return ans;
    }

    private int countOne(char[] arr) {
        int ans = 0;
        char curr = arr[0];
        int count = 0;

        for (char val : arr) {
            if (val == curr) {
                count++;
            } else {
                curr = val;
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    private int countTwo(char n1, char n2, char[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == n1) {
                sum++;
            } else if (arr[i] == n2) {
                sum--;
            } else {
                map = new HashMap<>();
                sum = 0;
                map.put(0, i);
                continue;
            }

            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return ans;
    }

    private int countThree(char[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int a = 0, b = 0, c = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a')
                a++;
            else if (arr[i] == 'b')
                b++;
            else
                c++;

            int diff1 = a - b;
            int diff2 = a - c;

            String key = diff1 + "#" + diff2;

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }
}

