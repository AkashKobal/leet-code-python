class Solution {
    public int minPartitions(String n) {
        int val=0;

        for(char c:n.toCharArray()){
            val = Math.max(val, c-'0');
            
            if(val==9) return 9;
        }

        return val;
    }
}