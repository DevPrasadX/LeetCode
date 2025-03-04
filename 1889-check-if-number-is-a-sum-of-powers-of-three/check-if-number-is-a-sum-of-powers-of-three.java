class Solution {
    public boolean checkPowersOfThree(int n) {
       while (n > 0) {
// according to the rule,a number can be written as a sum of powers of 3 'if and only if its base-3 representation consists of only 0s and 1s.' now 

        if (n % 3 == 2) {
            return false;
        }
 //we knww that numbers are stored in decimal form (base 10). so to check if number is sum of power of 3, we cannot do this in base 10, so we start dividing the number by 3 if its nor false
        n /= 3;
    }

    return true;
        
    }
}