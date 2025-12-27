class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[n];
        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            freeRoom.offer(i);
        }
        PriorityQueue<long[]> used = new PriorityQueue<>(
            (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
            }
        );
        for (int[] m : meetings){
            long start = m[0], end = m[1];
            while (!used.isEmpty() && used.peek()[0] <= start){
                int room = (int) used.poll()[1];
                freeRoom.offer(room);
            }
            long dur = end - start;
            int room;
            long begin;
            if (!freeRoom.isEmpty()){
                room = freeRoom.poll();
                begin = start;
            } else {
                long[] earliest =  used.poll();
                long delay = earliest[0];
                room = (int) earliest[1];
                begin = delay;
            }
            count[room]++;
            used.offer(new long[]{begin + dur, room});
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (count[i] > count[ans]){
                ans = i;
            }
        }
        return ans;
    }
}