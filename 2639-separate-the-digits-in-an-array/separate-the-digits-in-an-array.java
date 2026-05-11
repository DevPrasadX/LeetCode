class Solution {
    public int[] separateDigits(int[] arr) {
        List<Character> list = new ArrayList<>();
       for (int num : arr) {

            String str = String.valueOf(num);

          
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }


        }
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i) - '0';
        }

        return array;
        
    }
}