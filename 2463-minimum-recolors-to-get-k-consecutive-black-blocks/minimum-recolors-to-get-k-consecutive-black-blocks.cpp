class Solution {
public:
    int minimumRecolors(string blocks, int k) {
         int w_count = 0, min_recolors;
        
        for (int i = 0; i < k; i++) {
            if (blocks[i] == 'W') w_count++;
        }
        
        min_recolors = w_count;

        for (int i = k; i < blocks.size(); i++) {
            if (blocks[i - k] == 'W') w_count--;  
            if (blocks[i] == 'W') w_count++;     
            min_recolors = min(min_recolors, w_count);
        }

        return min_recolors;
    
        
    }
};