class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pointing the first and last index of pre and post;
        int n = preorder.length;
        return solve(preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode solve(int[] preoder, int psi, int pei, int[] inorder, int isi, int iei){

      // base case
      if(isi > iei)return null;

      // find the last index element of preorder in the inorder
      int idx = isi;
      while(inorder[idx] != preoder[psi])idx++;

      // make the TreeNode and pass the left sub-tree and right sub-tree
      TreeNode node = new TreeNode(inorder[idx]);
      int tel = idx - isi;

      node.left = solve(preoder, psi+1, psi+tel, inorder, isi, idx-1);
      node.right = solve(preoder, psi+tel+1, pei, inorder, idx+1, iei);

      return node;
    }
}
