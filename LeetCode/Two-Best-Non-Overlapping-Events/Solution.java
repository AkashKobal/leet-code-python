import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, res = 0, len =events.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?b[1]-a[1]:b[0]-a[0]);
        for(int i=0; i<len; i++){
            pq.add(events[i]);
            min = Math.min(min, events[i][0]);
            max = Math.max(max, events[i][1]);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(max+1, 0);
        int currMax = 0;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            currMax = Math.max(currMax, a[2]);
            map.put(a[0], currMax);
        }
        for(int i=0; i<len; i++){
            int curr = events[i][2];
            int pair = map.get(map.ceilingKey(events[i][1]+1));
            res = Math.max(res, curr+pair);
        }
        return res;
    }
}