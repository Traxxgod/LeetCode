class Solution {
    public String smallestSubsequence(String s) {
        int count[] = new int[26];
        boolean added[] = new boolean[26];
        
        for(int i=s.length()-1;i>=0;i--)count[s.charAt(i)-'a']++;
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(added[c-'a']){
                count[c-'a']--;
                continue;
            }
            while(st.size() > 0 && st.peek() > c && count[st.peek()-'a'] > 0){
                added[st.pop()-'a'] = false;
            }
            
            st.add(c);
            added[c-'a'] = true;
            count[c-'a']--;
        }
        
        char ch[] = new char[st.size()];
        int i = ch.length-1;
        while(i>=0)ch[i--] = st.pop();
        
        return new String(ch);
    }
}