// class Solution {
//     public int[] secondGreaterElement(int[] nums) {
//         Stack<Integer> st = new Stack<>();
//         int[] nge = new int[nums.length];
//         // st.push(0);
//         for(int i=0;i<nums.length;i++){
//             while(st.size() > 0 && nums[i] > nums[st.peek()]){
//                 int idx = st.pop();
//                 nge[idx] = i;
//             }
//             st.push(i);
//         }
//         while(st.size() > 0){
//             nge[st.pop()] = 1000000;
//         }
//         for(int i=0;i<nums.length;i++){
//             int idx = nge[i]+1;
//             while(idx<nums.length && nums[i] >= nums[idx]){
//                 idx = nge[idx];
//             }
//             if(idx >= nums.length)nge[i] = -1;
//             else nge[i] = nums[idx];
//         }
//         return nge;
//     }
// }
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        for (int i=0; i < nums.length; i++) {
            while(!s2.isEmpty() && nums[i] > nums[s2.getLast()]) {
                ans[s2.removeLast()] = nums[i];
            }
            LinkedList temp = new LinkedList<>();
            while(!s1.isEmpty() && nums[i] > nums[s1.getLast()]) {
                temp.addFirst(s1.removeLast());
            }
            s2.addAll(temp);
            s1.addLast(i);
        }
        return ans;
    }
}