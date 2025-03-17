class Solution {
    public boolean divideArray(int[] arr) {
        Arrays.sort(arr);
        List <List<Integer>> numbers=new ArrayList<>();
        boolean hasNonEqualPair=false;
        if(arr.length%2==0)
        {
            for (int i = 0; i < arr.length; i += 2) {
                List<Integer> subarray = new ArrayList<>();
                subarray.add(arr[i]);
                if (i + 1 < arr.length) { 
                    subarray.add(arr[i + 1]);
                    if (arr[i]!=arr[i + 1]) { 
                        hasNonEqualPair = true;
                    }
                }
                numbers.add(subarray);
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
