1import java.math.BigInteger;
2
3class Solution {
4    public String addBinary(String a, String b) {
5        BigInteger x = new BigInteger(a, 2);
6        BigInteger y = new BigInteger(b, 2);
7        BigInteger zero = new BigInteger("0", 2);
8        BigInteger carry, answer;
9
10        while (y.compareTo(zero) != 0) {
11            answer = x.xor(y);
12            carry = x.and(y).shiftLeft(1);
13            x = answer;
14            y = carry;
15        }
16
17        return x.toString(2);
18    }
19}
20