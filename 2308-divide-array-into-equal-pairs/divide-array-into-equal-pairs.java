class Solution {
    public boolean divideArray(int[] arr) {
        Arrays.sort(arr); // we will be sorting the arrays first. so if in pair, we can notice that equal values will obv be next to each other
        boolean hasNonEqualPair=false;
        if(arr.length%2==0) // logically if array size is odd, it cant have pairs with same value inside. at the end, only 1 element will be remained whihc is not paired. so if this condition is not satisfied, obv we will return false
        {
            for (int i = 0; i < arr.length; i += 2) {
                if (i + 1 < arr.length) { 
                    if (arr[i]!=arr[i + 1]) {       
                        hasNonEqualPair = true;  // here we simply check if the returning subarray's values are equal or not. if not equal, we will flag this var as true
                    }
                }
            }
        }
        else
        {
            return false;
        }
       
        if(hasNonEqualPair==true)
        {
            return false;
        }
        return true;


    }
    }
