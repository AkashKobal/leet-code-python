class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet();

        //Storing into SET 
        for(String str:nums){
            set.add(binstrToInt(str));
        }

        //Finding the MAX for all 1 in binary length of n
        char[] chrs=new char[n];
        Arrays.fill(chrs,'1');
        String maxStr=new String(chrs);
        int maxValue=binstrToInt(maxStr);

        //Checking from MAX to ZERO, which is not present in SET, return it 
        for(int i=maxValue; i>=0; i--){
            if(!set.contains(i)){
                return intToBinstr(i, n);
            }
        }
       
        return "";
    }

    int binstrToInt(String bin){
        int num=0;
        int p=bin.length()-1;
        for(char ch:bin.toCharArray()){
            num+= Integer.parseInt(String.valueOf(ch))*Math.pow(2,p--);            
        }
        return num;
    }

    String intToBinstr(int num, int n){
        char[] chrs=new char[n];
        Arrays.fill(chrs,'0');
        int i=n-1;
        while(num!=0){
            chrs[i--]=Character.forDigit(num%2,2);
            num/=2;
        }
        return new String(chrs);
    }

}