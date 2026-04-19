class Solution {
    public int strStr(String haystack, String needle) {
       
 
        int hayStackLength = haystack.length();
        int needleLength = needle.length();
        int diff = hayStackLength - needleLength;
        if(needleLength > hayStackLength) return -1;

        for( int start=0;start<=diff;start++)
        {
            for(int i=0;i<needleLength;i++)
            {
                if(needle.charAt(i)!=haystack.charAt(start+i))
                {
                    break;
                }
                if(i==needleLength-1)
                {
                    return start;
                }
            }
        }
        return -1;
        
    }
}