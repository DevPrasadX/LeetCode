class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        set.add(beginWord);
        queue.add(beginWord);
      
        int count = 1;
        
        
       if (!wordList.contains(beginWord)) {
    wordList.add(beginWord);
}
        
        System.out.println(wordList);
   
        for(String word:wordList)
        {
            for(int j=0;j<word.length();j++)
            {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                // System.out.println(wordList);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        while(!queue.isEmpty())
        {
              int queueSize=queue.size();
            for(int i = 0; i<queueSize;i++)
            {
                String word = queue.poll();
                if( word.equals(endWord))
                {
                    return count;
                }
                else
                {
                    for(int j=0;j<word.length();j++)
                    {
                        String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                        for (String neighbourWord : map.getOrDefault(pattern, new ArrayList<>()))
                        {
                            if(!set.contains(neighbourWord))
                            {
                                set.add(neighbourWord);
                                queue.add(neighbourWord);
                            }
                        }
                         map.put(pattern, new ArrayList<>());
                       
                    }
                }
            }
            count++;
        }

        return 0;
        
    }
}