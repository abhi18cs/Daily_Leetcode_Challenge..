class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // here we first calculate the frequency of each character in the letters array
        // in ASCII 'a' means 1 so if ch is c then ch - 'a' = 3 - 1 = 2 so freqArr[2]++
        int[] freqArray = new int[score.length];
        for(char ch : letters) {
            freqArray[ch - 'a']++;
        }
        // We call score starting from first word that is index 0
        return score(words,score,freqArray,0);
    }
     private static int score(String[] words, int[] score, int[] freqArray, int index) {
        // If we reach the end of words the return 0 this is base condition
        if(index == words.length) return 0;
        String word = words[index];
        // If we dont include the current word then the currentWordScore is 0 and we go ahead with finding the score of the next word
        int scoreIfWordNotIncluded = score(words,score,freqArray,index+1);
        int scoreIfWordIncluded = 0;
        int scoreOfCurrentWord = 0;
        boolean canCurrentWordBeIncluded = true;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If the frequency of the character becomes 0 or is 0 then we cannot include the word as either the letter is not present is letters array or we have used up all the letters from the letters array
            if(freqArray[ch - 'a'] == 0) canCurrentWordBeIncluded = false;
            // Once the letter is used, decrement the count of the letter from the freq array
            freqArray[ch - 'a']--;
            // score of current word is score of every letter included (summed)
            scoreOfCurrentWord += score[ch - 'a'];
        }
        // If the current word is included then find the total score by also finding the score of the next word
        if(canCurrentWordBeIncluded) {
            scoreIfWordIncluded = scoreOfCurrentWord + score(words,score,freqArray,index+1);
        }
        // If current word is not included then increment the character frequency which we decremented previously for that word
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freqArray[ch - 'a']++;
        }
        // Finally the result is the maximum of score of weather word was included or not
        return Math.max(scoreIfWordNotIncluded,scoreIfWordIncluded);
    }
}