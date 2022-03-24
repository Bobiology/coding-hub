package trees;


public class SerializeDeserialize {
	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
	 int i;
	    StringBuilder sb;
	    public String serialize(TreeNode root) {
	        sb=new StringBuilder();
	        preOrderTraversal(root);
	        sb.setLength(sb.length()-1);
	        return sb.toString();
	    }
	    void preOrderTraversal(TreeNode root){
	        if(root==null){
	            sb.append("N").append(" ");
	            return;
	        }
	        sb.append(root.val).append(" ");
	        preOrderTraversal(root.left);
	        preOrderTraversal(root.right);
	    }
	    public TreeNode deserialize(String data) {
	        String[] n=data.split("\\s+");
	        i=0;
	        return deserializer(n);
	    }
	    TreeNode deserializer(String[] n){
	        if(i>=n.length || i<0 || n[i].compareTo("N")==0){
	            i++;
	            return null;
	        }
	        TreeNode current=new TreeNode(Integer.parseInt(n[i]));
	        i++;
	        current.left=deserializer(n);
	        current.right=deserializer(n);
	        return current;
	    }
}