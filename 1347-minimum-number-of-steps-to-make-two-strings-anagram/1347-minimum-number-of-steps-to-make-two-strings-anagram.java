class Solution {
    public int minSteps(String s, String t) {
        // STEP1:
        // There are 26 alphabets so we create array of size 26.
        int [] map = new int[26];

        // STEP2:
        for(char ch: s.toCharArray())
        {
        // The ASCII value of 'a' is 97 and 'z' is 122
        // To keep the range between 0 - 25 we need to subtract 'a'
            map[ch-'a']--;
        }

        // STEP3:
        for(char ch: t.toCharArray())
        {
            map[ch-'a']++;
        }

        // STEP4:
        int count = 0;
        for(int i=0; i < 26; i++)
        {
            // if frequency is > 0 then store it in count.
            if(map[i] > 0)
            {
                count += map[i];
            }
        }

        // Finally, return the count variable.
        return count;
    }
}