class Solution {
    public String reverseWords(String s) {
        // Trim leading and tailing whitespace
        s = s.trim();
        // Dealing with cases that there are multiple whitespaces between words
        String[] wordsList = s.split("\\s+");
        int left = 0, right = wordsList.length - 1;
        while(left < right) {
            String temp = wordsList[left];
            wordsList[left] = wordsList[right];
            wordsList[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : wordsList) {
            sb.append(word);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}