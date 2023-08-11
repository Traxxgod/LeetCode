class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // First i have to make pointers which is pointing the starting index and ending index of 
        // preorder and postorder
        int n = postorder.length;
        return solve(preorder, 0, n-1, postorder, 0, n-1);
    }

    public TreeNode solve(int[] preorder, int presi, int preei, int[] postorder, int postsi, int postei){
      //base case
      if(presi > preei)return null;

      TreeNode node = new TreeNode(preorder[presi]);
      //if the array having one elemnet than we can not access the given below [presi+1] so
      if(presi == preei)return node;

      //find the element of pre in post
      int idx = postsi;
      while(postorder[idx] != preorder[presi+1]){
        idx++;
      }

      int tel = idx - postsi;
      node.left = solve(preorder, presi+1, presi+1+tel, postorder, postsi, idx);
      node.right = solve(preorder, presi+1+tel+1, preei, postorder, idx+1, postei);
      return node;
    }
}