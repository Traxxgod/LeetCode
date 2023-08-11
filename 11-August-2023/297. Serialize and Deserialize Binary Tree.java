public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "n";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + " " + left +  " " + right;
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(" ");
        int idx = 0;

        return deserialize_(arr);
    
    }
    public TreeNode deserialize_(String[] arr) {
        
        if(arr[idx].equals("n")){
          idx++;
          return null;
        }else{
          TreeNode node = new TreeNode(Integer.parseInt(arr[idx]));
          idx++;
          node.left = deserialize_(arr);
          node.right = deserialize_(arr);
          return node;
        }

    
    }
}