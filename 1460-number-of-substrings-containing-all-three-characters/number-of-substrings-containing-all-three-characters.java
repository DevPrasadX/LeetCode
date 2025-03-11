class Solution {
    public int numberOfSubstrings(String s) {
//    BELOW APPROACH EXCEEDED TIME LIMIT SO TRIED WITH SLIDING WINDOW ALGORITHM
    //     List<String> substrings = new ArrayList<>();
    // int count=0;
    //     for (int i = 0; i < str.length(); i++) {
    //         for (int j = i + 1; j <= str.length(); j++) {
    //             String sub = str.substring(i, j);
    //             if (sub.contains("a") && sub.contains("b") && sub.contains("c")) {
    //                 count++;
    //             }
    //         }
    //     }

    //     return count;

        int[] lastSeen = {-1, -1, -1}; 
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            lastSeen[s.charAt(right) - 'a'] = right; 
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }
        return count;
    }
}

