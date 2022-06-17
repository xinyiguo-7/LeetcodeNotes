class Solution {
    public String countAndSay(int n) {
        String result = "1";
        
        for(int i = 2; i <= n; i++) {
            result = buildStr(result);
        }
        return result;        
    }
    
    public String buildStr(String lastStr) {
        StringBuilder newStr = new StringBuilder();
        int idx = 0;
        while(idx < lastStr.length()) {
            // To handle both count == 1 and count > 1 cases
            char val = lastStr.charAt(idx);
            int count = 0;
            
            while(idx < lastStr.length() && 
              lastStr.charAt(idx) == val){
                idx++;
                count++;
            }
            newStr.append(String.valueOf(count));
            newStr.append(val);
        }
        return newStr.toString();
    }
}