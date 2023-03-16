class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && s.charAt(i) == st.peek()){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        String str = "";
        while(st.size()>0){
            str = st.pop() + str;
        }
        return str;
    }
}