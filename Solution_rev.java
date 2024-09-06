class Solution_rev {
    public String reverseWords(String s) {
        int start = 0;
        int end = s.length();
        StringBuilder sbb = new StringBuilder();

        while (start < end) {
            // Skip leading spaces
            while (start < end && s.charAt(start) == ' ') {
                start++;
            }

            // Find the end of the current word
            int j = start;
            while (j < end && s.charAt(j) != ' ') {
                j++;
            }

            // Extract the word if it exists
            if (start < j) {
                String word = s.substring(start, j);
                if (sbb.length() > 0) {
                    sbb.insert(0, " ");  // Prepend a space before the next word
                }
                sbb.insert(0, word);  // Prepend the word itself
            }

            // Move start to the next word
            start = j + 1;
        }

        return sbb.toString();  // Return the reversed words
    }
}
