class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        String str = "";
        int i=1;
        for(i=1;i<=pattern.length();i++){
            if(pattern.charAt(i-1) == 'I'){
                st.push(i);
                while(st.size()>0){
                    str += st.pop();
                }
            }else{
                st.push(i);
            }
        }
        st.push(i);
        while(st.size()>0){
            str += st.pop();
        }
        return str;
    }
}