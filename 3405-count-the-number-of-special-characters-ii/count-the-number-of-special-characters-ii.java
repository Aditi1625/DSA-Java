class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        // initialize
        for(int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = -1;
        }

        // traverse string
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i;
            } 
            else {
                int idx = ch - 'A';

                // store first uppercase occurrence only
                if(firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int count = 0;

        // check special letters
        for(int i = 0; i < 26; i++) {
            if(lastLower[i] != -1 &&
               firstUpper[i] != -1 &&
               lastLower[i] < firstUpper[i]) {
                count++;
            }
        }

        return count;
    }
}