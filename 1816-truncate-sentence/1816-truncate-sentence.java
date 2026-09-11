class Solution {
    public String truncateSentence(String s, int k) {
        
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int i = 1;
        int start = 0;
        int end = 0;
        while(i <= k){
            while(end < n && s.charAt(end) != ' '){
                end++;
            }

            String str = s.substring(start, end);
            sb.append(str);
            if(i != k){
                sb.append(" ");
            }
            

            start = end+1;
            end++;
            i++;
        }

        return sb.toString();
    }
}