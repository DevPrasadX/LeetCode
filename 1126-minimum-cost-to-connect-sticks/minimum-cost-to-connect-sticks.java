class Solution {
    public int connectSticks(int[] sticks) {
        /**
        2,4,3
        sort
        2,3,4
        2+3 = 5
        5,4
        5+4 = 9

         */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks)
        {
            pq.add(stick);
        }
        int totalCost = 0;
        while(pq.size()>1)
        {
           int stick1 = pq.remove();
           int stick2 = pq.remove();
           int  sum = stick1+stick2;
           totalCost=totalCost+sum;
           pq.add(stick1+stick2);

        }
      
       
        return totalCost;
    }
}