class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, 0, preorder.length-1);
    }

    public TreeNode solve(int[] preorder, int psi, int pei){
      if(psi > pei)return null;

      TreeNode node = new TreeNode(preorder[psi]);
      if(psi == pei)return node;

      int idx = psi+1;
      while(idx <= pei && preorder[idx] < preorder[psi]){
        idx++;
      }


      node.left = solve(preorder, psi+1, idx-1);
      node.right = solve(preorder, idx, pei);
      return node;
    }
}