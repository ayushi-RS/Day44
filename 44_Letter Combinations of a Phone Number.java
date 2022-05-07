class Solution {
       private static final String[] digitStrings = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> toReturn = new ArrayList<>();
        
        if(digits.length() <= 0) return toReturn;
        
        dfs(digits, 0, new StringBuilder(), toReturn);
        
        return toReturn;
    }
    
    private void dfs(String digits, int curDigitIdx, StringBuilder curResult, List<String> results) {
        if(curDigitIdx >= digits.length()) {
            results.add(curResult.toString());
            return;
        }
        
        int curResultIndex = curResult.length();
        char digitChar = digits.charAt(curDigitIdx);
        
        int digitIdx = digitChar - '0';
        String digitStr = digitStrings[digitIdx];
        
        for(int i = 0; i < digitStr.length(); i++) {
            char toAppend = digitStr.charAt(i);
            
            curResult.append(toAppend);
            dfs(digits, curDigitIdx + 1, curResult, results);
            curResult.delete(curResultIndex, curResult.length());
        }
    }

}