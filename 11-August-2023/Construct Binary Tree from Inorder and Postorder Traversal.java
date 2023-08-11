class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
               // pointing the first and last index of post and in;
        int n = postorder.length;
        return solve(postorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode solve(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei){

      // base case
      if(isi > iei)return null;

      // find the last index element of postorder in the inorder
      int idx = isi;
      while(inorder[idx] != postorder[pei])idx++;

      // make the TreeNode and pass the left sub-tree and right sub-tree
      TreeNode node = new TreeNode(inorder[idx]);
      int tel = iei - idx;

      node.right = solve(postorder, pei-tel, pei-1, inorder, idx+1, iei);
      node.left = solve(postorder, psi, pei-tel-1, inorder, isi, idx-1);

      return node; 
    }
}