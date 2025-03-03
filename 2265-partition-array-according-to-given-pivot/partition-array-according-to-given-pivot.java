class Solution {
    public int[] pivotArray(int[] num, int pivot) {
        int[] less = new int[num.length];
        int[] more =  new int[num.length];
        int[] pivotele =  new int[num.length];
        // [less][pivot][more] print the array in this way
        int p=0; int l=0;int m=0;

        for(int i=0;i<num.length;i++)
        {
            if(num[i]==pivot)
            {
               pivotele[p]=num[i];
               p++;
                               
            }
            else if(num[i]>pivot)
            {
                more[m]=num[i];
                m++;
            }
            else if(num[i]<pivot)
            {
                less[l]=num[i];
                l++;
            }
        }
        int[] result = new int[l + p + m];
        int j = 0;
        for (int i = 0; i < l; i++) result[j++] = less[i];
        for (int i = 0; i < p; i++) result[j++] = pivotele[i];
        for (int i = 0; i < m; i++) result[j++] = more[i];
    
    return result;
        
    }
}