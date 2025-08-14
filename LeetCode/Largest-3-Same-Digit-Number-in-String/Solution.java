class Solution {
    public String largestGoodInteger(String num) {
        int largestDigit=-1;
        for(int i=0;i<=num.length()-3;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2)){
                largestDigit=Math.max(largestDigit,Integer.valueOf(num.substring(i,i+3)));
            }
        }
        return largestDigit==-1?"":(largestDigit==0?"000":Integer.toString(largestDigit));
    }
}